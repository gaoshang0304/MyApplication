//package com.junchao.frametest.utils;
//
//import android.app.Activity;
//import android.app.Dialog;
//import android.content.Context;
//import android.text.TextUtils;
//import android.view.Gravity;
//import android.view.View;
//
//import com.junchao.frametest.R;
//
//import java.util.HashMap;
//
///**
// * 分享弹框
// * <p/>
// * 1.2.0 zhangmao 2015-08-25
// */
//public class DialogForShare extends Dialog implements View.OnClickListener, PlatformActionListener {
//
//    private static final String TAG = DialogForShare.class.getSimpleName();
//
//    private Context mContext;
//    private ShareBean mShareBean;//分享内容
//    private OnActionListener mOnActionListener;
//
//    public DialogForShare(Context context) {
//        this(context, R.style.common_loading_dialog);
//    }
//
//    public DialogForShare(Context context, int theme) {
//        super(context, theme);
//        mContext = context;
//        // other init
//        setCancelable(true);
//        setCanceledOnTouchOutside(true);
//        init();
//    }
//
//    public void init() {
//        setContentView(R.layout.dialog_share);
//
//        // 方便以后添加相关动画
//        // mDialogView =
//        // getWindow().getDecorView().findViewById(android.R.id.content);
//
//        findViewById(R.id.share_tv_wechat).setOnClickListener(this);
//        findViewById(R.id.share_tv_qq).setOnClickListener(this);
//        findViewById(R.id.share_tv_moments).setOnClickListener(this);
//        findViewById(R.id.share_tv_qzone).setOnClickListener(this);
//        findViewById(R.id.share_tv_weibo).setOnClickListener(this);
//        findViewById(R.id.share_tv_cancel).setOnClickListener(this);
//
//        getWindow().setGravity(Gravity.CENTER);
//    }
//
//    public void setGravity(int gravity) {
//        // lp 用来设置具体的偏移量
//        // WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//        getWindow().setGravity(gravity);
//    }
//
//    /**
//     * 分享相关内容
//     *
//     * @param shareBean
//     * @return
//     */
//    public DialogForShare setShareParams(ShareBean shareBean) {
//        mShareBean = shareBean;
//        return this;
//    }
//
//    @Override
//    public void onClick(View v) {
//        dismiss();
//        switch (v.getId()) {
//            case R.id.share_tv_wechat:
//                boolean flag = AppVersionUtil.isAppInstalled(mContext, Constants.WE_CHAT_PACKAGE);
//                if (flag) {// 有微信客户端
//                    share(Wechat.NAME);
//                } else {// 没有微信客户端，提示是否下载
//                    new CommonDialog(mContext, R.style.common_dialog)
//                            .setTitleVisible(false)
//                            .setContent(R.string.install_we_chat)
//                            .setButtonText(R.string.cancel, R.string.confirm)
//                            .setOnClickButtonListener(new CommonDialog.OnClickButtonListener() {
//
//                                @Override
//                                public void onClickButtonLeft() {
//                                }
//
//                                @Override
//                                public void onClickButtonRight() {
//                                    AppVersionUtil.gotoMarket(mContext, Constants.WE_CHAT_PACKAGE);
//                                }
//                            }).show();
//                }
//                break;
//            case R.id.share_tv_qq:
//                share(QQ.NAME);
//                break;
//            case R.id.share_tv_moments:
//                share(WechatMoments.NAME);
//                break;
//            case R.id.share_tv_qzone:
//                //qq空间分享
//                //QQ空间分享时一定要携带title、titleUrl、site、siteUrl
//                //sp.setTitle("测试Title");
//                //sp.setTitleUrl("http://www.baidu.com"); // 标题的超链接
//                //sp.setText("Text文本内容 http://www.baidu.com");
//                //sp.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
//                //sp.setSite("sharesdk");
//                //sp.setSiteUrl("http://sharesdk.cn");
//                //share(QZone.NAME);
//                QZone.ShareParams sp = new QZone.ShareParams();
//                sp.setTitle(mShareBean.qq.title);
//                sp.setTitleUrl(mShareBean.url); // 标题的超链接
//                sp.setText(mShareBean.qq.content);
//                if (TextUtils.isEmpty(mShareBean.image)) {
//                    sp.setImageUrl(UrlConstants.ZJDG_LOGO);
//                } else {
//                    sp.setImageUrl(mShareBean.image);
//                }
//                sp.setSite(mContext.getString(R.string.app_name));
//                sp.setSiteUrl(UrlConstants.OFFICIAL_WEBSITE);
//
//                LogUtil.e("zjdg_app", "Title=====" + mShareBean.qq.title);
//                LogUtil.e("zjdg_app", "TitleUrl=====" + mShareBean.url);
//                LogUtil.e("zjdg_app", "Text===" + mShareBean.qq.content);
//                LogUtil.e("zjdg_app", "ImageUrl==" + mShareBean.image);
//
//                Platform plat = ShareSDK.getPlatform(mContext, QZone.NAME);
//                plat.setPlatformActionListener(this);// 设置分享事件回调
//                plat.share(sp);// 执行分享
//                break;
//            case R.id.share_tv_weibo:
//                share(SinaWeibo.NAME);
//                break;
//            default:
//                break;
//        }
//    }
//
//    private void share(String platName) {
//        if (mShareBean == null) {
//            return;
//        }
//
//        ShareParams params = new ShareParams();
//        params.setSite(mContext.getString(R.string.app_name));
//        params.setSiteUrl(UrlConstants.OFFICIAL_WEBSITE);
//        params.setShareType(Platform.SHARE_WEBPAGE);// 微信和易信的字段，分享内容的类型
//        params.setTitleUrl(mShareBean.url);
//        params.setUrl(mShareBean.url);
//        if (TextUtils.isEmpty(mShareBean.image)) {
//            params.setImageUrl(UrlConstants.ZJDG_LOGO);
//        } else {
//            params.setImageUrl(mShareBean.image);
//        }
//
//        Platform plat = ShareSDK.getPlatform(mContext, platName);
//        plat.SSOSetting(false);//设置false表示使用SSO授权方式
//        plat.setPlatformActionListener(this);// 设置分享事件回调
//
//        if (QZone.NAME.equals(platName) || QQ.NAME.equals(platName)) {
//            plat.share(getQQParams(params));
//
//        } else if (Wechat.NAME.equals(platName)) {
//            plat.share(getWechatParams(params));
//
//        } else if (WechatMoments.NAME.equals(platName)) {
//            plat.share(getMomentsParams(params));
//
//        } else if (SinaWeibo.NAME.equals(platName)) {
//            plat.share(getWeiboParams(params));
//
//        } else {
//            LogUtil.d(TAG, "Not supported platform: " + platName);
//        }
//    }
//
//    private ShareParams getWechatParams(ShareParams params) {
//        params.setTitle(mShareBean.wechat.title);
//        params.setText(mShareBean.wechat.content);
//        return params;
//    }
//
//    private ShareParams getMomentsParams(ShareParams params) {
//        params.setTitle(mShareBean.moments.title);
//        params.setText(mShareBean.moments.content);
//        return params;
//    }
//
//    private ShareParams getQQParams(ShareParams params) {
//        params.setTitle(mShareBean.qq.title);
//        params.setText(mShareBean.qq.content);
//        return params;
//    }
//
//    private ShareParams getWeiboParams(ShareParams params) {
//        params.setTitle(mShareBean.weibo.title);
//        params.setText(mShareBean.weibo.content);
//        return params;
//    }
//
//    @Override
//    public void dismiss() {
//        super.dismiss();
//    }
//
//    /**
//     * 在UI线程弹出Toast
//     */
//    private void showToastOnMainThread(final int resId) {
//        try {
//            if (mContext instanceof Activity) {
//                ((Activity) mContext).runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        ToastUtil.showToast(mContext, mContext.getString(resId));
//                    }
//                });
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // ====================/PlatformActionListener/====================
//
//    @Override
//    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
//        showToastOnMainThread(R.string.share_success);
//        if (mOnActionListener != null && mShareBean.extra != null) {
//            int couponId = mShareBean.extra.getInt(Extra.COUPON_ID, -1);
//            if (couponId != -1) {
//                mOnActionListener.onShareSuccess(couponId);
//            }
//        }
//    }
//
//    @Override
//    public void onError(Platform platform, int i, Throwable throwable) {
//        throwable.printStackTrace();
//        showToastOnMainThread(R.string.share_failed);
//    }
//
//    @Override
//    public void onCancel(Platform platform, int i) {
//        showToastOnMainThread(R.string.share_cancel);
//    }
//
//    public DialogForShare setOnActionListener(OnActionListener listener) {
//        mOnActionListener = listener;
//        return this;
//    }
//
//    public interface OnActionListener {
//        /**
//         * 分享成功
//         */
//        void onShareSuccess(int couponId);
//    }
//
//}
