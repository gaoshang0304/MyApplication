package com.junchao.frametest.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * 检测更新工具类
 *
 */
//public class CheckUpdateUtil {
//
//    /**
//     * @param context
//     * @param isAutoCheck 是否是启动程序时的自动检测，如果是自动检测时有新版本时给出提示，其它情况均静默；
//     *                    如果是用户手动检测新版本则对各种情况进行提示
//     */
//    public static void checkUpdate(final Context context, final boolean isAutoCheck) {
//        HttpClientUtils.getLatestVersion(context, new TextHttpResponseHandler() {
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, String responseString) {
//                LogUtil.json(responseString);
//                try {
//                    Response response = JSON.parseObject(responseString, Response.class);
//                    if (0 == response.error) {
//                        NewVersionInfo data = JSON.parseObject(response.data, NewVersionInfo.class);
//                        if (!(AppConfig.APP_VERSION.equals(data.apk_version)) && data.apk_code > Integer.parseInt(AppVersionUtil.getVersionCode(context))) {
//                            try {
//                                showNewVersionDialog(context, data);
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        } else {
//                            if (!isAutoCheck) {
//                                ToastUtil.showToast(context, R.string.alert_already_have_latest_version);
//                            }
//                        }
//                    } else {
//                        if (!isAutoCheck) {
//                            ToastUtil.showToast(context, response.message);
//                        }
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    if (!isAutoCheck) {
//                        ToastUtil.showToast(context, R.string.alert_check_update_fail);
//                    }
//                }
//            }

//            @Override
//            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
//                LogUtil.json(responseString);
//                if (!isAutoCheck) {
//                    ToastUtil.showToast(context, R.string.alert_check_update_fail);
//                }
//            }
//        });
//    }
//
//    private static void showNewVersionDialog(final Context context, final NewVersionInfo bean) {
//        if (null == context) {
//            return;
//        }
//        new CommonDialog(context, R.style.common_dialog)
//                .setTitleText(context.getString(R.string.dialog_new_version_title) + bean.apk_version)
//                .setContent(bean.apk_des)
//                .setButtonText(R.string.dialog_new_version_next_time, R.string.dialog_new_version_right_now)
//                .setOnClickButtonListener(new CommonDialog.OnClickButtonListener() {
//
//                    @Override
//                    public void onClickButtonLeft() {
//                        MainActivity.isNewVersionExist = true;
//                    }
//
//                    @Override
//                    public void onClickButtonRight() {
//                        MainActivity.isNewVersionExist = false;
//                        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bean.apk_url)));
//                    }
//                }).show();
//    }

//}
