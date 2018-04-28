package com.junchao.frametest.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 用来存储主页头部数据(除热门商品外)
 *
 * @author lgh
 * @version 1.3.2
 * @since 2016-01-25
 */
public class SharePreHome {
	public static final String CACHE_HOME 		= "home_new_data";
	public static final String HOME_NEW_DATA 	= "homeNewDatas";		// 首页数据(除热门商品外)
	public static final String HOME_SUPER_DATA 	= "homeSuperDatas";		// 首页数据超级返
	//判断是否是第一次打开
	public static final String IS_FIRST_OPEN 	= "firstOpen";			// 是否首次打开应用
	public static final String IS_FIRST_OPEN_SEARCH_HIS 	= "firstOpenSearchHis";	// 是否首次打开搜索历史
	public static final String IS_FIRST_OPEN_QWG 	= "firstOpenQwg";	// 是否首次打开全网购

	public static final String KEFU_CODE 		= "error_code";			// 客服有效服务时间
	public static final String KEFU_MESSAGE 	= "kefu_message";		// 消息
	public static final String DETAIL_RULES 	= "good_detail_rules";  // 商品详情规则
	public static final String KEFU_RULES  	= "kefu_show_rules";  	// 是否显示客服按钮规则
	public static final String SALE_SELF_RULES = "zjzy_rules";  		// 中捷自营规则
	public static final String SAVE_ADDRESS 	= "save_address";  		// 搜索地址页面,选择地址后,存储
	public static final String SAVE_LATITUDE 	= "save_latitude";  	// 附近购主页,存储定位纬度
	public static final String SAVE_LONGITUDE 	= "save_longitude";  	// 附近购主页,存储定位经度
	public static final String SUPER_CATEGORY 	= "super_category";  	// 超返,20封顶,9.9包邮分类数据
	public static final String CHECK_VERSION 	= "check_version";  	// 检查省市县版本是否需要更新
	public static final String CITY_JSON_DATA 	= "city_json_data";  	// 存储省市县数据
	public static final String CREATE_ORDER_SELECT_ADDRESS 	= "create_order_select_address";  	// 创建订单页选择地址menu  1门店自提 2邮寄到家
	public static final String GET_ASYN_DATA 	= "get_asyn_data";  	// 获取js
	public static final String TAOBAO_UNAME 	= "taobao_uname";  	    // 淘宝用户名
	public static final String TAOBAO_PASSWORD = "taoba_password"; // 淘宝密码
	private SharedPreferences.Editor 	edit 			= null;
	private static SharePreHome 		instance;
	private SharedPreferences sp 				= null;
	private Context context;

	public SharePreHome(Context context) {
//		this(context,CACHE_HOME + "_" + AppConfig.APP_VERSIONCODE);
	}

	/**
	 * Create SharedPreferences by filename
	 *
	 * @param context
	 * @param filename
	 */
	private SharePreHome(Context context, String filename) {
		this(context, context.getSharedPreferences(filename, Context.MODE_PRIVATE));
	}

	/**
	 * Create SharedPreferences by SharedPreferences
	 *
	 * @param context
	 * @param sp
	 */
	private SharePreHome(Context context, SharedPreferences sp) {
		this.context = context;
		this.sp = sp;
		edit = sp.edit();
	}

	public static SharePreHome getHomeInstance(Context context) {
		if (instance == null) {
			instance = new SharePreHome(context);
		}
		return instance;
	}

	// Boolean
	public SharePreHome setValue(String key, boolean value) {
		edit.putBoolean(key, value);
		edit.commit();
		return SharePreHome.this;
	}

	public SharePreHome setValue(int resKey, boolean value) {
		setValue(this.context.getString(resKey), value);
		return SharePreHome.this;
	}

	// String
	public SharePreHome setValue(String key, String value) {
		edit.putString(key, value).commit();
		return SharePreHome.this;
	}

	public SharePreHome setValue(int resKey, String value) {
		setValue(this.context.getString(resKey), value);
		return SharePreHome.this;
	}

	// Boolean
	public boolean getValue(String key, boolean defaultValue) {
		return sp.getBoolean(key, defaultValue);
	}

	public boolean getValue(int resKey, boolean defaultValue) {
		return getValue(this.context.getString(resKey), defaultValue);
	}

	// String
	public String getValue(String key, String defaultValue) {
		return sp.getString(key, defaultValue);
	}

	public String getValue(int resKey, String defaultValue) {
		return getValue(this.context.getString(resKey), defaultValue);
	}

}
