package cn.gdptc.xxgcx.munetext.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import cn.gdptc.xxgcx.munetext.MainActivity;
import cn.gdptc.xxgcx.munetext.R;
import cn.gdptc.xxgcx.munetext.SQL.MD5Utils;

public class LoginActivity extends AppCompatActivity {
    private ImageView back;
    private Button register, login;
    private String userName, psw, spPsw;//获取的用户名，密码，加密密码
    private EditText et_user_name, et_psw;//编辑框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        back = findViewById(R.id.back);
        register = findViewById(R.id.register);
            initView();
            init();
        }


        private void initView() {
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   finish();
                }
            });
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
            });
        }
        private void init() {
            //从activity_login.xml中获取的
            register = findViewById(R.id.register);
            login = findViewById(R.id.login);
            et_user_name = findViewById(R.id.et_name);
            et_psw = findViewById(R.id.et_password);
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //为了跳转到注册界面，并实现注册功能
                    Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                    startActivityForResult(intent, 1);
                }
            });

            //登录按钮的点击事件
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //开始登录，获取用户名和密码 getText().toString().trim();
                    userName=et_user_name.getText().toString().trim();
                    psw=et_psw.getText().toString().trim();
                    //对当前用户输入的密码进行MD5加密再进行比对判断, MD5Utils.md5( ); psw 进行加密判断是否一致
                    String md5Psw= MD5Utils.md5(psw);
                    // md5Psw ; spPsw 为 根据从SharedPreferences中用户名读取密码
                    // 定义方法 readPsw为了读取用户名，得到密码
                    spPsw=readPsw(userName);
                    // TextUtils.isEmpty
                    if(TextUtils.isEmpty(userName)){
                        Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                        return;
                    }else if(TextUtils.isEmpty(psw)){
                        Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                        return;
                        // md5Psw.equals(); 判断，输入的密码加密后，是否与保存在SharedPreferences中一致
                    }else if(md5Psw.equals(spPsw)){
                        //一致登录成功
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        //保存登录状态，在界面保存登录的用户名 定义个方法 saveLoginStatus boolean 状态 , userName 用户名;
                        saveLoginStatus(true, userName);
                        //登录成功后关闭此页面进入主页
                        Intent data=new Intent();
                        //datad.putExtra( ); name , value ;
                        data.putExtra("isLogin",true);
                        data.putExtra("username",userName);
                        //RESULT_OK为Activity系统常量，状态码为-1
                        // 表示此页面下的内容操作成功将data返回到上一页面，如果是用back返回过去的则不存在用setResult传递data值
                        setResult(RESULT_OK,data);
                        //销毁登录界面
                        LoginActivity.this.finish();
                        //跳转到主界面，登录成功的状态传递到 MainActivity 中
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        SharedPreferences sharedPreferences=getSharedPreferences("flag",MODE_PRIVATE);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putBoolean("islogin",true);
                        if(loginstatue!=null){
                            loginstatue.Loginsuccesslitning(userName);
                        }
                        edit.commit();

                        return;
                    }else if((spPsw!=null&&!TextUtils.isEmpty(spPsw)&&!md5Psw.equals(spPsw))){
                        Toast.makeText(LoginActivity.this, "输入的用户名和密码不一致", Toast.LENGTH_SHORT).show();
                        return;
                    }else{
                        Toast.makeText(LoginActivity.this, "此用户名不存在", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        /**
         *从SharedPreferences中根据用户名读取密码
         */
        private String readPsw(String userName){
            //getSharedPreferences("loginInfo",MODE_PRIVATE);
            //"loginInfo",mode_private; MODE_PRIVATE表示可以继续写入
            SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
            //sp.getString() userName, "";
            return sp.getString(userName , "");
        }
        /**
         *保存登录状态和登录用户名到SharedPreferences中
         */
        private void saveLoginStatus(boolean status,String userName){
            //saveLoginStatus(true, userName);
            //loginInfo表示文件名  SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
            SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
            //获取编辑器
            SharedPreferences.Editor editor=sp.edit();
            //存入boolean类型的登录状态
            editor.putBoolean("isLogin", status);
            //存入登录状态时的用户名
            editor.putString("loginUserName", userName);
            //提交修改
            editor.commit();
        }
        /**
         * 注册成功的数据返回至此
         * @param requestCode 请求码
         * @param resultCode 结果码
         * @param data 数据
         */
        @Override
        //显示数据， onActivityResult
        //startActivityForResult(intent, 1); 从注册界面中获取数据
        //int requestCode , int resultCode , Intent data
        // LoginActivity -> startActivityForResult -> onActivityResult();
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            //super.onActivityResult(requestCode, resultCode, data);
            if(data!=null){
                //是获取注册界面回传过来的用户名
                // getExtra().getString("***");
                final String userName=data.getStringExtra("userName");
                if(!TextUtils.isEmpty(userName)){
                    et_user_name = findViewById(R.id.et_name);
                    et_user_name.setText(userName+"");
                    //et_user_name控件的setSelection()方法来设置光标位置
                    //  et_user_name.setSelection(userName.length());
                }
            }
            super.onActivityResult(requestCode, resultCode, data);

        }
        public static Loginstatue loginstatue;

    }





