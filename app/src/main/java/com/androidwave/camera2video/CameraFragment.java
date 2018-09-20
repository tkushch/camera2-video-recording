package com.androidwave.camera2video;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidwave.camera2video.camera.AutoFitTextureView;
import com.androidwave.camera2video.camera.CameraVideoFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CameraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CameraFragment extends CameraVideoFragment {


    @InjectView(R.id.mTextureView)
    AutoFitTextureView mTextureView;
    @InjectView(R.id.btnPlay)
    ImageView btnPlay;

    private String mOutputFilePath;

    public CameraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */


    public static CameraFragment newInstance() {
        CameraFragment fragment = new CameraFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public int getTextureResource() {
        return R.id.mTextureView;
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @OnClick(R.id.btnPlay)
    public void onViewClicked() {
        if (mIsRecordingVideo) {
            try {
                stopRecordingVideo();
                btnPlay.setImageResource(R.drawable.ic_play_button);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            startRecordingVideo();
            btnPlay.setImageResource(R.drawable.ic_stop);
            //Receive out put file here
            mOutputFilePath = getCurrentFile().getAbsolutePath();
        }

    }
}
