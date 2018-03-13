package com.mvp.alan.project.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.mvp.alan.project.R;

import java.util.ArrayList;

/**
 * Created by lu on 2015/8/31.
 */
public class NumberKeyBoardPopupWindows extends PopupWindow {
    private ArrayList<ImageView> imgvList = new ArrayList<ImageView>();
    EditText password_ed;
    String pwd_old;
    String first_paw,last_paw;
    public NumberKeyBoardPopupWindows(final Context context, View view) {


        setWidth(WindowManager.LayoutParams.FILL_PARENT);
        setHeight(WindowManager.LayoutParams.FILL_PARENT);
        setBackgroundDrawable(new BitmapDrawable());
        setFocusable(true);
        setOutsideTouchable(true);
        setContentView(view);
        showAtLocation(view, Gravity.BOTTOM, 0, 0);
        update();

        ImageView imgv_poup_mima6 = (ImageView) view.findViewById(R.id.imgv_poup_mima6);
        ImageView imgv_poup_mima5 = (ImageView) view.findViewById(R.id.imgv_poup_mima5);
        ImageView imgv_poup_mima4 = (ImageView) view.findViewById(R.id.imgv_poup_mima4);
        ImageView imgv_poup_mima3 = (ImageView) view.findViewById(R.id.imgv_poup_mima3);
        ImageView imgv_poup_mima2 = (ImageView) view.findViewById(R.id.imgv_poup_mima2);
        ImageView imgv_poup_mima1 = (ImageView) view.findViewById(R.id.imgv_poup_mima1);
        LinearLayout lin_poup_mima = (LinearLayout) view.findViewById(R.id.lin_poup_mima);
        imgvList.clear();
        imgvList.add(imgv_poup_mima1);
        imgvList.add(imgv_poup_mima2);
        imgvList.add(imgv_poup_mima3);
        imgvList.add(imgv_poup_mima4);
        imgvList.add(imgv_poup_mima5);
        imgvList.add(imgv_poup_mima6);
        password_ed = (EditText) view.findViewById(R.id.password_ed);
        password_ed.addTextChangedListener(textWatcher);
        view.findViewById(R.id.digitkeypad_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
//                WalrusApplication.prefrenceUtil.put("first_paw", first_paw);
//                WalrusApplication.showToast(WalrusApplication.prefrenceUtil.getString("ss", ""));
            }
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            pwd_old = password_ed.getText() + "";

        }

        @Override
        public void afterTextChanged(Editable s) {
            String pwd = password_ed.getText() + "";
            first_paw=s.toString();
            if(s.toString().length()==6){
//             for(int i=0;i<s.length();i++)
//             {
//                 HanYaApplication.prefrenceUtil.put("first_paw", first_paw);
//                 imgvList.get(pwd.length()).setBackgroundColor(Color.parseColor("#00000000"));
//             }
            }


            // 输入密码之后显示圆点
            if (pwd_old.length() < pwd.length()) {
                imgvList.get(pwd.length() - 1).setBackgroundResource(R.mipmap.imgv_poup_dian);
            } else {
                // 退格圆点消失变成背景色
                imgvList.get(pwd.length()).setBackgroundColor(Color.parseColor("#00000000"));
            }
            // 如果输入法在窗口上已经显示，则隐藏，反之则显示
            if (pwd.length() >= 6) {
            }
        }
    };
}