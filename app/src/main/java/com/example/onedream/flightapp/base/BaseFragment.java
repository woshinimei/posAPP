package com.example.onedream.flightapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/a/m14.
 */

public abstract class BaseFragment extends Fragment {
    Unbinder bind;
    private boolean isCreated = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = View.inflate(getContext(), getlayout(), null);
        Log.e("----onCreateView----", "--------");
        bind = ButterKnife.bind(this, layout);
        isCreated = true;
        return layout;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            String fragmentName = getClass().getSimpleName();
            Log.e("---当前frgment---", fragmentName + "");
            if (isCreated) {
                lazyData();
            }
        }
    }

    public abstract void lazyData();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    public abstract int getlayout();

    public abstract void initView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (bind != null) {
            bind.unbind();
        }
    }

    OnGetDataListener getDataListener;

    public interface OnGetDataListener {
        void getData();
    }

    public OnGetDataListener getDataListener() {
        return getDataListener;
    }

    public void setOnGetDataListener(OnGetDataListener getDataListener) {
        this.getDataListener = getDataListener;
    }

    public void showToast(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
