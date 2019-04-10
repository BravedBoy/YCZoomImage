package com.ycbjie.yczoomimage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ycbjie.zoomimagelib.listener.OnZoomClickListener;
import com.ycbjie.zoomimagelib.listener.OnZoomLongClickListener;
import com.ycbjie.zoomimagelib.utils.ZoomUtils;
import com.ycbjie.zoomimagelib.view.ZoomImageView;

/**
 * @author yc
 */
public class ImageActivity extends AppCompatActivity {

    private ZoomImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ZoomUtils.setLog(true);
        image = findViewById(R.id.image);
        image.setOnZoomClickListener(new OnZoomClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        image.setOnZoomLongClickListener(new OnZoomLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
        image.setMaxScale(2);
        image.setImageResource(R.mipmap.image1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //手动释放一下资源
        image.reset();
    }

}
