package me.jcala.xmarket.data.api;


import java.util.List;
import me.jcala.xmarket.conf.ApiConf;
import me.jcala.xmarket.data.pojo.DealItem;
import me.jcala.xmarket.data.dto.Result;
import me.jcala.xmarket.data.pojo.SortTag;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface UserReq {

    /**
     * 用户登录并获取用户信息和token
     */
    @POST(ApiConf.auth)
    Observable<Result<String>> login(
            @Field("username") String username,
            @Field("password") String password);

    /**
     * 用户注册请求
     */
    @POST(ApiConf.register)
    Observable<Result<String>> register(
            @Field("username")  String username,
            @Field("phone")  String phone,
            @Field("password")  String password);

    /**
     * 获取分类列表请求
     */
    @GET(ApiConf.get_trade_sort)
    Observable<Result<List<SortTag>>> sortTag();

    /**
     *获取本校在售商品列表
     */
    @GET(ApiConf.get_school_trades)
    Observable<Result<List<DealItem>>> schoolDeals(
            @Path("school")  String school,
            @Path("page") int page
    );




}