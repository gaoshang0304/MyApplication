package com.junchao.frametest.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;


/**
 * @author gjc
 * @version ;;
 * @since 2017-12-01
 */

//public class PermissionsUtil {
//
//    private static RxPermissions INSTANCE;
//
//    public static RxPermissions getInstance(Activity activity) {
//        if (INSTANCE == null) {
//
//            synchronized (RxPermissions.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new RxPermissions(activity);
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//    public static void getSinglePermission(final Activity activity, String permission, final String msgTip) {
//        PermissionsUtil.getInstance(activity)
//                .request(permission)
//                .subscribe(new Consumer<Boolean>() {
//
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//                        if (aBoolean) {
//                            ToastUtil.showToast(activity.getApplicationContext(), "授权成功");
//                        } else {
//                            showPermissionDialog(activity.getApplicationContext(), msgTip);
//                        }
//                    }
//                });
//    }

//    /**
//     * 对话框，提示用户到设置中设置权限
//     *
//     * @param context context
//     * @param msg     message
//     */
//    public static void showPermissionDialog(final Context context, String msg) {
//        AlertDialog dialog = new AlertDialog.Builder(context)
//                .setTitle("提示")
//                .setMessage(msg)
//                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                })
//                .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Uri packageURI = Uri.parse("package:" + context.getPackageName());
//                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
//                        context.startActivity(intent);
//                    }
//                })
//                .show();
//        dialog.setCanceledOnTouchOutside(true);
//    }
//}
