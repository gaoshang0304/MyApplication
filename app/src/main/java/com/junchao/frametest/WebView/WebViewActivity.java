package com.junchao.frametest.WebView;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ResourceBusyException;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.junchao.frametest.R;
import com.junchao.frametest.ui.MainActivity;
import com.junchao.frametest.ui.base.ToolbarBaseActivity;
import com.junchao.frametest.utils.LogUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用web view页
 *
 * @author gjc
 * @version 1.2.2
 * @since 2017-09-28
 */
public class WebViewActivity extends ToolbarBaseActivity implements View.OnClickListener {

    private String mUrl;
    private WebView wv_content;
    private TextView tv_title;
    private ValueCallback<Uri> mSingleFileCallback;
    private ValueCallback<Uri[]> mMultiFileCallback;
    private final static int FILECHOOSER_RESULTCODE = 1;// 表单的结果回调</span>
    private Uri imageUri;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initUI() {
        setToolBar(toolbarBaseActivity, "");
        mUrl = "http://m.taobao.com/";
        mUrl = "file:///android_asset/h5.html";
        mUrl = "http://dev.h5.zjdg.cn/account/FeedBackIndex";
        init();
    }

    private void init() {

        wv_content = (WebView) findViewById(R.id.web_view);
        wv_content.clearCache(true);
        wv_content.getSettings().setUseWideViewPort(true);// 宽度自适应手机屏幕
        wv_content.getSettings().setDomStorageEnabled(true);
        wv_content.getSettings().setAllowFileAccess(true);
        wv_content.getSettings().setAllowFileAccessFromFileURLs(true);
        wv_content.getSettings().setJavaScriptEnabled(true);
        wv_content.getSettings().setLoadsImagesAutomatically(true);//
        wv_content.getSettings().setLoadWithOverviewMode(true);//
        wv_content.getSettings().setUseWideViewPort(true);//
        wv_content.getSettings().setDefaultTextEncodingName("utf-8");
        wv_content.setWebChromeClient(new CustomWebChromeClient());
        wv_content.setWebViewClient(new CustomWebClient());
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            wv_content.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        wv_content.loadUrl(mUrl);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


        }
    }

    @Override
    public void onBackPressed() {
        if (wv_content.canGoBack()) {
            wv_content.goBack();
        } else {
            finish();
        }
    }

    public class CustomWebChromeClient extends WebChromeClient {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setToolBar(toolbarBaseActivity, title);
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean onShowFileChooser(WebView webView,
                                         ValueCallback<Uri[]> filePathCallback,
                                         FileChooserParams fileChooserParams) {
            mMultiFileCallback = filePathCallback;
            take();
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> uploadMsg) {
            mSingleFileCallback = uploadMsg;
            take();
        }

        public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
            mSingleFileCallback = uploadMsg;
            take();
        }

        public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
            mSingleFileCallback = uploadMsg;
            take();
        }
    }

    public class CustomWebClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            super.onPageStarted(view, url, favicon);
        }


        @Override
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.e("size = " + "-----------");
        if (requestCode == FILECHOOSER_RESULTCODE) {
            if (mSingleFileCallback == null && mMultiFileCallback == null) {
                return;
            }
            Uri tempUri = null;
            if (data != null) {
                String url = getPath(WebViewActivity.this, data.getData());
                File temp = new File(url);
                tempUri = Uri.fromFile(temp);
            }

            if (mSingleFileCallback != null) { // 5.0以下处理方式
                if (data != null) {
                    mSingleFileCallback.onReceiveValue(tempUri);
                } else {
                    mSingleFileCallback.onReceiveValue(imageUri);
                }
                mSingleFileCallback = null;
            } else if (mMultiFileCallback != null) { // 5.0版本以上
                Uri[] uris = null;
                if (data == null) {
                    uris = new Uri[] {imageUri};
                } else {
                    // 多选图片[图片一定要压缩，转化为base网页加载很慢]
                    String dataString = data.getDataString();
                    ClipData clipData = data.getClipData();
                    if (clipData != null) {
                        int size = clipData.getItemCount();
                        LogUtil.e("size = " + size);
                        uris = new Uri[size];
                        for (int i = 0; i < size; i++) {
                            // 将所选图片的 url保存到 uris数组中
                            uris[i] = clipData.getItemAt(i).getUri();
                        }
                    }
                    if (!TextUtils.isEmpty(dataString)) {
                        uris = new Uri[] {Uri.parse(dataString)};
                    }
                }

                if (uris == null) {
                    mMultiFileCallback.onReceiveValue(null);
                    mMultiFileCallback = null;
                } else {
                    mMultiFileCallback.onReceiveValue(uris);
                    mMultiFileCallback = null;
                }
            }
        }
    }

    private void take() {
        File imageStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MyApp");
        // Create the storage directory if it does not exist
        if (!imageStorageDir.exists()) {
            imageStorageDir.mkdirs();
        }
        File file = new File(imageStorageDir + File.separator + "IMG_" + String.valueOf(System.currentTimeMillis()) + ".jpg");
        imageUri = Uri.fromFile(file);

        final List<Intent> cameraIntents = new ArrayList<Intent>();
        final Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        final PackageManager packageManager = getPackageManager();
        final List<ResolveInfo> listCam = packageManager.queryIntentActivities(captureIntent, 0);
        for (ResolveInfo res : listCam) {
            final String packageName = res.activityInfo.packageName;
            final Intent i = new Intent(captureIntent);
            i.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            i.setPackage(packageName);
            i.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            cameraIntents.add(i);

        }
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        Intent chooserIntent = Intent.createChooser(i, "Image Chooser");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, cameraIntents.toArray(new Parcelable[]{}));
        WebViewActivity.this.startActivityForResult(chooserIntent, FILECHOOSER_RESULTCODE);
    }

    @SuppressLint("NewApi")
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String getPath(final Context context, final Uri uri) {
        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }

                // TODO handle non-primary volumes
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }


    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     *
     * @param context       The context.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if (cursor != null) cursor.close();
        }
        return null;
    }


    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }


    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }


    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
