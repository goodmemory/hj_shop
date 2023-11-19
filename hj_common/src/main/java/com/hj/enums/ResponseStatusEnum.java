package com.hj.enums;

/**
 * 响应结果枚举，用于提供给GraceJSONResult返回给前端的
 * 本枚举类中包含了很多的不同的状态码供使用，可以自定义
 * 便于更优雅的对状态码进行管理，一目了然
 */
public enum ResponseStatusEnum {

    SUCCESS(200, true, "操作成功！"),
    FAILED(500, false, "操作失败！"),

    // 50x
    UN_LOGIN(501, false, "请登录后再继续操作！"),
    TICKET_INVALID(502, false, "会话失效，请重新登录！"),
    NO_AUTH(503, false, "您的权限不足，无法继续操作！"),
    MOBILE_ERROR(504, false, "短信发送失败，请稍后重试！"),
    MOBILE_IS_EMPTY(510, false, "手机号不能为空！"),
    SMS_NEED_WAIT_ERROR(505, false, "短信发送太快啦~请稍后再试！"),
    SMS_CODE_ERROR(506, false, "验证码过期或不匹配，请稍后再试！"),
    USER_FROZEN(507, false, "用户已被冻结，请联系管理员！"),
    USER_UPDATE_ERROR(508, false, "用户信息更新失败，请联系管理员！"),
    USER_INACTIVE_ERROR(509, false, "请前往[账号设置]修改信息激活后再进行后续操作！"),
    USER_INFO_UPDATED_ERROR(5091, false, "用户信息修改失败！"),
    USER_INFO_UPDATED_NICKNAME_EXIST_ERROR(5092, false, "昵称已经存在！"),
    USER_INFO_UPDATED_IMOOCNUM_EXIST_ERROR(5092, false, "慕课号已经存在！"),
    USER_INFO_CANT_UPDATED_IMOOCNUM_ERROR(5092, false, "慕课号无法修改！"),
    FILE_UPLOAD_NULL_ERROR(510, false, "文件不能为空，请选择一个文件再上传！"),
    FILE_UPLOAD_FAILD(511, false, "文件上传失败！"),
    FILE_FORMATTER_FAILD(512, false, "文件图片格式不支持！"),
    FILE_MAX_SIZE_500KB_ERROR(5131, false, "仅支持500kb大小以下的图片上传！"),
    FILE_MAX_SIZE_2MB_ERROR(5132, false, "仅支持2MB大小以下的图片上传！"),
    FILE_NOT_EXIST_ERROR(514, false, "你所查看的文件不存在！"),
    USER_STATUS_ERROR(515, false, "用户状态参数出错！"),
    USER_NOT_EXIST_ERROR(516, false, "用户不存在！"),

    // 自定义系统级别异常 54x
    SYSTEM_INDEX_OUT_OF_BOUNDS(541, false, "系统错误，数组越界！"),
    SYSTEM_ARITHMETIC_BY_ZERO(542, false, "系统错误，无法除零！"),
    SYSTEM_NULL_POINTER(543, false, "系统错误，空指针！"),
    SYSTEM_NUMBER_FORMAT(544, false, "系统错误，数字转换异常！"),
    SYSTEM_PARSE(545, false, "系统错误，解析异常！"),
    SYSTEM_IO(546, false, "系统错误，IO输入输出异常！"),
    SYSTEM_FILE_NOT_FOUND(547, false, "系统错误，文件未找到！"),
    SYSTEM_CLASS_CAST(548, false, "系统错误，类型强制转换错误！"),
    SYSTEM_PARSER_ERROR(549, false, "系统错误，解析出错！"),
    SYSTEM_DATE_PARSER_ERROR(550, false, "系统错误，日期解析出错！"),

    // admin 管理系统 56x
    ADMIN_USERNAME_NULL_ERROR(561, false, "管理员登录名不能为空！"),
    ADMIN_USERNAME_EXIST_ERROR(562, false, "管理员登录名已存在！"),
    ADMIN_NAME_NULL_ERROR(563, false, "管理员负责人不能为空！"),
    ADMIN_PASSWORD_ERROR(564, false, "密码不能为空后者两次输入不一致！"),
    ADMIN_CREATE_ERROR(565, false, "添加管理员失败！"),
    ADMIN_PASSWORD_NULL_ERROR(566, false, "密码不能为空！"),
    ADMIN_NOT_EXIT_ERROR(567, false, "管理员不存在或密码错误！"),
    ADMIN_FACE_NULL_ERROR(568, false, "人脸信息不能为空！"),
    ADMIN_FACE_LOGIN_ERROR(569, false, "人脸识别失败，请重试！"),
    CATEGORY_EXIST_ERROR(570, false, "文章分类已存在，请换一个分类名！"),

    //用户投诉分类信息
    FEEDBACK_CATEGORY_ERROR(571, false, "不可添加更低阶分类！"),
    FEEDBACK_CATEGORY_PARENT_LABEL_ERROR(572, false, "请选择父类标签！"),
    FEEDBACK_CATEGORY_NAME_ERROR(572, false, "分类名称不能为空！"),
    FEEDBACK_CATEGORY_ID_ERROR(572, false, "分类id不能为空！"),

    //用户投诉信息
    FEEDBACK_ID_ERROR(580, false, "用户投诉信息id不能为空！"),


    //会员权益
    MEMBER_INTERESTS_NAME_NOT_NULL(590, false, "会员权益名称不能为空！"),
    MEMBER_INTERESTS_INFO_NOT_NULL(591, false, "会员权益简介不能为空！"),
    MEMBER_INTERESTS_NAME_SAME(592, false, "会员权益名称已存在！"),
    MEMBER_INTERESTS_ID_NOT_NULL(593, false, "会员权益ID不能为空！"),

    //会员等级
    MEMBER_LEVEL_NAME_NOT_NULL(600, false, "会员名称不能为空！"),
    MEMBER_LEVEL_NOT_NULL(601, false, "会员等级不能为空！"),
    MEMBER_LEVEL_ICON_NOT_NULL(602, false, "会员图标不能为空！"),
    MEMBER_LEVEL_IMAGE_NOT_NULL(603, false, "会员背景图不能为空！"),
    MEMBER_LEVEL_VALUE_NOT_NULL(604, false, "会员所需成长值不能为空！"),
    MEMBER_LEVEL_RATIO_NOT_NULL(605, false, "会员积分赔率不能为空！"),
    MEMBER_LEVEL_NOT_SAME(606, false, "会员等级已存在！"),
    MEMBER_LEVEL_ID_NOT_NULL(607, false, "会员等级ID不能为空！"),

    //用户
    USER_ACCOUNT_NOT_NULL(610, false, "用户账号不能为空！"),
    USER_PSW_NOT_NULL(611, false, "用户密码不能为空！"),
    USER_CONFIRM_PSW_NOT_NULL(612, false, "用户确认密码不能为空！"),
    USER_NICKNAME_NOT_NULL(612, false, "用昵称不能为空！"),
    USER_CARDID_INVALID(613, false, "用户身份证输入不合法！"),
    USER_PHONE_INVALID(614, false, "用户手机号输入不合法！"),
    USER_ACCOUNT_INVALID(615, false, "用户账号输入不合法！"),
    USER_CONFIRM_PSW_NO_SAME(616, false, "两次输入密码不一致！"),
    USER_ACCOUNT_EXIST(616, false, "用户账号已存在请重新输入！"),
    USER_ID_NOT_NULL(617, false, "用户ID不能为空！"),
    USER_MONEY_NOT_NEGATIVE(618, false, "当前减少红旌币额度大于现有总额度，请重新输入额度！"),
    USER_INTEGRAL_NOT_NEGATIVE(619, false, "当前减少积分额度大于现有总额度，请重新输入额度！"),

    //文章
    ARTICLE_TITLE_NOT_NULL(630, false, "文章标题不能为空！"),
    ARTICLE_AUTHOR_NOT_NULL(631, false, "文章作者不能为空！"),
    ARTICLE_CATEGORY_NOT_NULL(632, false, "文章分类不能为空！"),
    ARTICLE_IMAGE_NOT_NULL(633, false, "图文封面不能为空！"),
    ARTICLE_ID_NOT_NULL(634, false, "文章ID不能为空！"),
    ARTICLE_NOT_EXIST(635, false, "文章不存在！"),

    //文章分类
    ARTICLE_CATEGORY_TITLE_NOT_NULL(640, false, "文章分类标题不能为空！"),
    ARTICLE_CATEGORY_ID_NOT_NULL(641, false, "文章分类ID不能为空！"),
    ARTICLE_CATEGORY_NOT_EXIST(642, false, "文章分类不存在！"),

    //商户分类
    MERCHANT_CATEGORY_NAME_NOT_NULL(645, false, "商户分类名称不能为空！"),
    MERCHANT_CATEGORY_ID_NOT_NULL(646, false, "商户分类ID不能为空！"),
    //商户
    MERCHANT_NAME_NOT_NULL(647, false, "商户名称不能为空！"),
    MERCHANT_ID_NOT_NULL(648, false, "商户分类ID不能为空！"),
    MERCHANT_CATEGORY_NOT_NULL(649, false, "商户分类不能为空！"),
    MERCHANT_TYPE_NOT_NULL(650, false, "商户类型不能为空！"),

    //商品分类
    STORE_CATEGORY_NAME_NOT_NULL(660, false, "商品分类名称不能为空！"),
    STORE_CATEGORY_ID_NOT_NULL(661, false, "商品分类ID不能为空！"),
    STORE_PID_NOT_NULL(662, false, "上级分类不能为空！"),

    //商品品牌分类
    STORE_BRAND_CATEGORY_NAME_NOT_NULL(665, false, "商品品牌分类名称不能为空！"),
    STORE_BRAND_CATEGORY_ID_NOT_NULL(666, false, "商品品牌分类ID不能为空！"),
    STORE_BRAND_CATEGORY_PID_NOT_NULL(667, false, "上级品牌分类不能为空！"),
    STORE_BRAND_CATEGORY_LOWER(668, false, "不可添加更低阶分类！"),
    //商品品牌
    STORE_BRAND_NAME_NOT_NULL(670, false, "商品品牌名称不能为空！"),
    STORE_BRAND_ID_NOT_NULL(671, false, "商品品牌ID不能为空！"),

    //评论
    STORE_PRODUCE_REPLY_ID_NOT_NULL(680, false, "评论ID不能为空！"),

    //商品
    STORE_PRODUCE_ID_NOT_NULL(681, false, "商品ID不能为空！"),
    //商标签
    STORE_PRODUCE_LABEL_ID_NOT_NULL(690, false, "商品标签ID不能为空！"),
    STORE_PRODUCE_LABEL_NAME_NOT_NULL(691, false, "商品标签名称不能为空！"),

    //保障服务
    GUARANTEE_NAME_NOT_NULL(700, false, "服务条款不能为空！"),
    GUARANTEE_INFO_NOT_NULL(701, false, "服务内容描述不能为空！"),
    GUARANTEE_IMAGE_NOT_NULL(702, false, "服务条款图标不能为空！"),
    GUARANTEE_ID_NOT_NULL(703, false, "服务ID不能为空！"),
    //订单
    ORDER_NO_NOT_NULL(710, false, "订单号不能为空！"),

    // 系统错误，未预期的错误 555
    SYSTEM_ERROR(555, false, "系统繁忙，请稍后再试！"),
    SYSTEM_OPERATION_ERROR(556, false, "操作失败，请重试或联系管理员"),
    SYSTEM_RESPONSE_NO_INFO(557, false, ""),
    SYSTEM_ERROR_GLOBAL(558, false, "全局降级：系统繁忙，请稍后再试！"),
    SYSTEM_ERROR_FEIGN(559, false, "客户端Feign降级：系统繁忙，请稍后再试！"),
    SYSTEM_ERROR_ZUUL(560, false, "请求系统过于繁忙，请稍后再试！");


    // 响应业务状态
    private Integer status;
    // 调用是否成功
    private Boolean success;
    // 响应消息，可以为成功或者失败的消息
    private String msg;

    ResponseStatusEnum(Integer status, Boolean success, String msg) {
        this.status = status;
        this.success = success;
        this.msg = msg;
    }

    public Integer status() {
        return status;
    }

    public Boolean success() {
        return success;
    }

    public String msg() {
        return msg;
    }
}
