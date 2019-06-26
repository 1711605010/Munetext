package cn.gdptc.xxgcx.munetext;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.gdptc.xxgcx.munetext.Fragment.ClassifyFragment;
import cn.gdptc.xxgcx.munetext.Fragment.HomeFragment;
import cn.gdptc.xxgcx.munetext.Fragment.MeFragment;
import cn.gdptc.xxgcx.munetext.Fragment.VideoFragment;

public class MainActivity extends AppCompatActivity {
    private TextView tv_main_title;
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private List<Fragment> alFragment=new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String touji = intent.getStringExtra("touji");
        if ( touji != null) {
            radioGroup.check(R.id.rb_me);
        }
        Intent intent1 = getIntent();
        String PS = intent.getStringExtra("PS");
        if ( PS != null) {
            radioGroup.check(R.id.rb_me);
        }

        initView();
        initViewPager();
        initListener();
    }

    private void initView() {
        tv_main_title=findViewById(R.id.tv_main_title);
        viewPager=findViewById(R.id.viewpager);
        radioGroup=findViewById(R.id.rg);
    }

    private void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        radioGroup.check(R.id.rb_home);
                        tv_main_title.setText("首页");
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_video);
                        tv_main_title.setText("图片");
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_classify);
                        tv_main_title.setText("分类");
                        break;
                    case 3:
                        radioGroup.check(R.id.rb_me);
                        tv_main_title.setText("我");
                        break;


                }
            }

            @Override
            public void onPageScrolled(int i,float v,int i1) {

            }


            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rb_home:
                        viewPager.setCurrentItem(0,false);break;
                    case R.id.rb_video:
                        viewPager.setCurrentItem(1,false);break;
                    case R.id.rb_classify:
                        viewPager.setCurrentItem(2,false);break;
                    case R.id.rb_me:
                        viewPager.setCurrentItem(3,false);break;
                }
            }
        });
    }

    private void initViewPager() {
        alFragment.add(new HomeFragment());
        alFragment.add(new VideoFragment());
        alFragment.add(new ClassifyFragment());
        alFragment.add(new MeFragment());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return alFragment.get(i);
            }

            @Override
            public int getCount() {
                return alFragment.size();
            }
        });
        viewPager.setCurrentItem(0);
    }


    static  String username;

    public void Loginsuccesslitning(String username) {
        this.username=username;
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show();
    }
}