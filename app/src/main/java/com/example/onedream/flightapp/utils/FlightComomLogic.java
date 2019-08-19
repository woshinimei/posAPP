package com.example.onedream.flightapp.utils;

import android.content.Context;
import android.text.TextUtils;

import com.example.onedream.flightapp.bean.DeliveryAndInvoiceInfo;
import com.example.onedream.flightapp.bean.FlightTicketDetailPrice;
import com.example.onedream.flightapp.bean.JbInfo;
import com.example.onedream.flightapp.bean.OrderDetail;
import com.example.onedream.flightapp.bean.PassengerInfo;
import com.example.onedream.flightapp.bean.PriceDetailedBen;
import com.example.onedream.flightapp.bean.PriceItem;
import com.example.onedream.flightapp.bean.PriceInfo;
import com.example.onedream.flightapp.constant.CacheFlightCommonData;

import java.util.ArrayList;
import java.util.List;

public class FlightComomLogic {
    /**
     * 初始化改签明细
     * */
    public   static void initEndorseDetailPriceInfo(OrderDetail parseendorseorderJson, PriceDetailedBen priceben) {

        if(parseendorseorderJson!=null){
            JbInfo jbxx = parseendorseorderJson.getJbxx();
            if(jbxx!=null){
                String cj = jbxx.getCj();
                if(!TextUtils.isEmpty(cj)){
                    priceben.setGqjpcj(cj);
                }


                String gqf = jbxx.getGqf();
                if(!TextUtils.isEmpty(gqf)){
                    priceben.setGqjpgqf(gqf);
                }
                String gqfwf = jbxx.getGqfwf();
                if(!TextUtils.isEmpty(gqfwf)){
                    priceben.setGqjpfwf(gqfwf);
                }
               /* String gqsxf = jbxx.getGqsxf();
                if(!TextUtils.isEmpty(gqsxf)){
                    priceben.setGqjpsxf(gqsxf);
                }*/


            }

        }


    }
    /**
     * 初始化改签明细
     * */
    public static    List<PriceInfo> initEndorePriceInfo(OrderDetail orderDetail, PriceDetailedBen priceben){

        List<PriceInfo>   priceInfos = new ArrayList<PriceInfo>();

        String gqjpcj = priceben.getGqjpcj();
        if(!TextUtils.isEmpty(gqjpcj)&&!"0".equals(FormatUtils.formatPrice(gqjpcj))){
            PriceInfo gqjpsxfinfo  = new PriceInfo();
            gqjpsxfinfo.setName("差价费");
            gqjpsxfinfo.setTotalPrice(Double.valueOf(gqjpcj));
            priceInfos.add(gqjpsxfinfo);

        }

        String gqjpgqf = priceben.getGqjpgqf();
        if(!TextUtils.isEmpty(gqjpgqf)&&!"0".equals(FormatUtils.formatPrice(gqjpgqf))){
            PriceInfo gqjpgqfinfo  = new PriceInfo();
            gqjpgqfinfo.setName("改签费");
            gqjpgqfinfo.setTotalPrice(Double.valueOf(gqjpgqf));
            priceInfos.add(gqjpgqfinfo);


        }
        String gqjpfwf = priceben.getGqjpfwf();
        if(!TextUtils.isEmpty(gqjpfwf)&&!"0".equals(FormatUtils.formatPrice(gqjpfwf))){
            PriceInfo gqjpfwfinfo  = new PriceInfo();
            gqjpfwfinfo.setName("服务费");
            gqjpfwfinfo.setTotalPrice(Double.valueOf(gqjpfwf));
            priceInfos.add(gqjpfwfinfo);


        }

        JbInfo baseinfo  = 	orderDetail.getJbxx();
        if(baseinfo!=null){
            String wjf = baseinfo.getWjf();
            if(!TextUtils.isEmpty(wjf)&&!"0".equals(FormatUtils.formatPrice(wjf))){
                PriceInfo wjfinfo  = new PriceInfo();
                wjfinfo.setName("误机费");
                wjfinfo.setTotalPrice(Double.valueOf(wjf));
                priceInfos.add(wjfinfo);


            }
            String cpfwf = baseinfo.getCpfwf();
            if (!TextUtils.isEmpty(cpfwf)){
                PriceInfo cpInfo = new PriceInfo();
                cpInfo.setName("产品服务费");
                cpInfo.setTotalPrice(Double.valueOf(cpfwf));
                priceInfos.add(cpInfo);
            }


        }



        DeliveryAndInvoiceInfo info = 	orderDetail.getFppsxx();
        if(info!=null){
            String yjpsf = info.getYjpsf();
            if(!TextUtils.isEmpty(yjpsf)&&!"0".equals(FormatUtils.formatPrice(yjpsf))){
                PriceInfo gqjppsfinfo  = new PriceInfo();
                gqjppsfinfo.setName("配送费");
                gqjppsfinfo.setTotalPrice(Double.valueOf(yjpsf));
                priceInfos.add(gqjppsfinfo);
            }



        }
        return priceInfos;
    }

    /**
     * 初始化 退票订单详的价格明细
     * @param parserefundJson
     * @param priceben
     */
    public static void initRefundDetailPriceInfo(OrderDetail parserefundJson, PriceDetailedBen priceben) {

        double xsj = 0;
        double jpjl = 0;
        double jj = 0;
        double jec = 0;
        double sf = 0;
        double qtsx = 0;
        double sxf = 0;
        double sfwf = 0;
        double ytje = 0;
        double     tjpbxje = 0;
        int tjpbxfs = 0;
        double couponCost = 0;
        double flightCouponsCost = 0;
        if(parserefundJson!=null){





            List<PassengerInfo> cjrjh = parserefundJson.getCjrjh();
            if(cjrjh!=null&&!cjrjh.isEmpty()){



                for (int i = 0; i <cjrjh.size() ; i++) {
                    PassengerInfo flightGetRefundDetailPassengerInfoResponse = cjrjh.get(i);

                    String pj = flightGetRefundDetailPassengerInfoResponse.getXsj();    //票价
                    try {
                        Double aDouble = Double.valueOf(pj);
                        xsj  =     Arith.add(xsj,aDouble);
                    }catch (Exception ption){

                    }
                /*    String ry = flightGetRefundDetailPassengerInfoResponse.getRy();   //燃油
                    try {
                        Double aDouble = Double.valueOf(ry);
                        tjprys  =     Arith.add(tjprys,aDouble);
                    }catch (Exception ption){
                    }*/

                    String jpjltv =    flightGetRefundDetailPassengerInfoResponse.getJpjl();  //机票奖励

                    try {
                        Double aDouble = Double.valueOf(jpjltv);
                        jpjl  =     Arith.add(jpjl,aDouble);

                    }catch (Exception ption){

                    }


                    double  jjtv= flightGetRefundDetailPassengerInfoResponse.getJj();   //机建费
                        jj  =     Arith.add(jj,jjtv);


                    String jec1 = flightGetRefundDetailPassengerInfoResponse.getJec();   //接车

                    try {
                        Double aDouble = Double.valueOf(jec1);
                        jec  =     Arith.add(jec,aDouble);

                    }catch (Exception ption){

                    }

                    String sf1 = flightGetRefundDetailPassengerInfoResponse.getSf();   //税费

                    try {
                        Double aDouble = Double.valueOf(sf1);
                        sf  =     Arith.add(sf,aDouble);

                    }catch (Exception ption){

                    }
                    String qtfx = flightGetRefundDetailPassengerInfoResponse.getQtfx();  //其他
                    try {
                        Double aDouble = Double.valueOf(qtfx);
                        qtsx  =     Arith.add(qtsx,aDouble);

                    }catch (Exception ption){

                    }

                    String sxf1 = flightGetRefundDetailPassengerInfoResponse.getSxf();  //手续费
                    try {
                        Double aDouble = Double.valueOf(sxf1);
                        sxf  =     Arith.add(sxf,aDouble);

                    }catch (Exception ption){

                    }
                    String sfwf1 = flightGetRefundDetailPassengerInfoResponse.getSfwf();  //收服务费
                    try {
                        Double aDouble = Double.valueOf(sfwf1);
                        sfwf  =     Arith.add(sfwf,aDouble);

                    }catch (Exception ption){

                    }



                    double bxdj = flightGetRefundDetailPassengerInfoResponse.getBxdj();//保险单价
                    //深圳航空G+S+X对接start
//                    int bxfs = flightGetRefundDetailPassengerInfoResponse.getBxfs();
                    int bxfs = 1;//默认勾选1份
                    //深圳航空G+S+X对接end
                        if(bxfs!=0){
                            double mul = Arith.mul(bxdj, bxfs);
                            tjpbxje = Arith.add(tjpbxje,mul);
                            tjpbxfs = tjpbxfs+bxfs;
                        }


//                    深圳航空G+S+X对接start
                    String couponFee = parserefundJson.getCouponCost();
                    try {
                        if (!TextUtils.isEmpty(couponFee)) {
                            couponCost = Double.valueOf(couponFee);
                            priceben.setCouponCost(couponCost);
                        }
                    } catch (Exception e) {
                    }
//                    深圳航空G+S+X对接end

                }
                try{
                    String jpyhje = parserefundJson.getJbxx().getJpyhje();
                    if (!TextUtils.isEmpty(jpyhje)){
                        flightCouponsCost = Double.valueOf(jpyhje);
                        priceben.setJpyhje(flightCouponsCost);
                    }
                }catch (Exception e){

                }

            }


            priceben.setTjpxsj(xsj);

            priceben.setTjpjpjl(jpjl);
            priceben.setTjpjj(jj);
            priceben.setTjpjec(jec);

            priceben.setTjpsf(sf);
            priceben.setTjpqtsx(qtsx);
            priceben.setTjpsxf(sxf);
            priceben.setTjpsfwf(sfwf);
            priceben.setTjpbxje(tjpbxje);






        }



    }

    public static  List<PriceInfo>  initDetailPriceRefundInfo(PriceDetailedBen priceben){
        List<PriceInfo>  priceinfos = new ArrayList<PriceInfo>();
        double tjpxsj = priceben.getTjpxsj();

        if(!"0".equals(FormatUtils.formatPrice(tjpxsj))){
            PriceInfo tjpxsjinfo = new PriceInfo();
            tjpxsjinfo.setName("票价");
            tjpxsjinfo.setTotalPrice(Double.valueOf(tjpxsj));
            priceinfos.add(tjpxsjinfo);
        }
        double tjpjpjl = priceben.getTjpjpjl();
        if(!"0".equals(FormatUtils.formatPrice(tjpjpjl))){
            PriceInfo tjprysinfo  = new PriceInfo();
            tjprysinfo.setName("机票奖励");
            tjprysinfo.setTotalPrice(Double.valueOf(tjpjpjl));
            priceinfos.add(tjprysinfo);
        }

        double tjpjj = priceben.getTjpjj();


        if(!"0".equals(FormatUtils.formatPrice(tjpjj))){
            PriceInfo tjpjjandsfinfo = new PriceInfo();
            tjpjjandsfinfo.setName("机建");
            tjpjjandsfinfo.setTotalPrice(Double.valueOf(tjpjj));
            priceinfos.add(tjpjjandsfinfo);
            //退机建/税费
        }
        double tjpjec = priceben.getTjpjec();

        if(!"0".equals(FormatUtils.formatPrice(tjpjec))){
            PriceInfo tjpjjandsfinfo = new PriceInfo();
            tjpjjandsfinfo.setName("接车");
            tjpjjandsfinfo.setTotalPrice(Double.valueOf(tjpjec));
            priceinfos.add(tjpjjandsfinfo);


        }
        double tjpsf = priceben.getTjpsf();
        if(!"0".equals(FormatUtils.formatPrice(tjpsf))){
            PriceInfo tjpjjandsfinfo = new PriceInfo();
            tjpjjandsfinfo.setName("税费");
            tjpjjandsfinfo.setTotalPrice(Double.valueOf(tjpsf));
            priceinfos.add(tjpjjandsfinfo);


        }
        double tjpqtsx = priceben.getTjpqtsx();

        if(!"0".equals(FormatUtils.formatPrice(tjpqtsx))){
            PriceInfo tjpjjandsfinfo = new PriceInfo();
            tjpjjandsfinfo.setName("其他费用");
            tjpjjandsfinfo.setTotalPrice(Double.valueOf(tjpqtsx));
            priceinfos.add(tjpjjandsfinfo);


        }
        // 商旅产品平台机+S+X对接 START
        //添加优惠券
        double couponCost = priceben.getCouponCost();
        if (couponCost!=0){
            PriceInfo couponInfo  = new PriceInfo();
            couponInfo.setName("产品服务费");
            couponInfo.setTotalPrice(couponCost);
            priceinfos.add(couponInfo);
        }
        // 商旅产品平台机+S+X对接 end
        double tjpsxf = priceben.getTjpsxf();
        if(!"0".equals(FormatUtils.formatPrice(tjpsxf))){
            PriceInfo tjpjjandsfinfo = new PriceInfo();
            tjpjjandsfinfo.setName("手续费");
            tjpjjandsfinfo.setTotalPrice(Double.valueOf(tjpsxf));
            priceinfos.add(tjpjjandsfinfo);
        }
        double tjpsfwf = priceben.getTjpsfwf();


        if(!"0".equals(FormatUtils.formatPrice(tjpsfwf))){
            PriceInfo tjpjjandsfinfo = new PriceInfo();
            tjpjjandsfinfo.setName("收服务费");
            tjpjjandsfinfo.setTotalPrice(Double.valueOf(tjpsfwf));
            priceinfos.add(tjpjjandsfinfo);


        }


        double tjpbxje = priceben.getTjpbxje();
        if(!"0".equals(FormatUtils.formatPrice(tjpbxje))){
            PriceInfo tjpnxje = new PriceInfo();
            tjpnxje.setName("保险金额");
            tjpnxje.setTotalPrice(Double.valueOf(tjpbxje));




				/*	String tjpbxfs = priceben.getTjpbxfs();

					if(!MyTextUtil.isEmpty(tjpbxfs)&&!"0".equals(FormatUtils.formatPrice(tjpbxfs))){

						ArrayList<PriceItem>  tjpbxjejh = new ArrayList<PriceItem>();

						PriceItem  tbxfs = new PriceItem();
						tbxfs.setName("退机票保险分数");
						//	tbxfs.setUnitPrice();
						tbxfs.setNumber(Integer.parseInt(tjpbxfs));

						tjpbxjejh.add(tbxfs);
						tjpnxje.setFjjh(tjpbxjejh);
					}*/



            priceinfos.add(tjpnxje);






        }
        //机票优惠券金额
        double jpyhje = priceben.getJpyhje();
        if (jpyhje!=0){
            PriceInfo jpyhInfo = new PriceInfo();
            jpyhInfo.setName("优惠券");
            jpyhInfo.setTotalPrice(jpyhje);
            priceinfos.add(jpyhInfo);
        }
        return priceinfos;
		/*		String tjpxsfwf = priceben.getTjpxsfwf();
				if(!MyTextUtil.isEmpty(tjpxsfwf)&&!"0".equals(FormatUtils.formatPrice(tjpxsfwf))){
					PriceInfo tjpxsfwfinfo = new PriceInfo();
					tjpxsfwfinfo.setName("退机票销售服务费");

					tjpxsfwfinfo.setTotoalPrice(Double.valueOf(tjpxsfwf));

					priceinfos.add(tjpxsfwfinfo);

				}
				String tjptpfwf = priceben.getTjptpfwf();
				if(!MyTextUtil.isEmpty(tjptpfwf)&&!"0".equals(FormatUtils.formatPrice(tjptpfwf))){

					PriceInfo tjptpfwfinfo = new PriceInfo();
					tjptpfwfinfo.setName("收退票服务费");
					tjptpfwfinfo.setTotoalPrice(Double.valueOf(tjptpfwf));

					priceinfos.add(tjptpfwfinfo);

				}
				String tjptpsxf = priceben.getTjptpsxf();
				if(!MyTextUtil.isEmpty(tjptpsxf)&&!"0".equals(FormatUtils.formatPrice(tjptpsxf))){

					PriceInfo tjptpsxfinfo = new PriceInfo();
					tjptpsxfinfo.setName("收退票服务费");
					tjptpsxfinfo.setTotoalPrice(Double.valueOf(tjptpfwf));

					priceinfos.add(tjptpsxfinfo);

				}*/

    }
    /**
     * 初始化详细价格信息展示(普通订单详情)
     * @param goTicketDetailPrice2
     * @param goresponse2
     */
    public static void initDetailPriceInfo(
            FlightTicketDetailPrice goTicketDetailPrice2, OrderDetail goresponse2) {

        int adultcount = 0;
        int childrencount =0;
        int babycount = 0;

        int insuranceadultcount = 0;
        int insurancechildrencount = 0;
        int insurancebabycount = 0;


        List<PassengerInfo> pif = goresponse2.getCjrjh();
        if(pif!=null&&pif.size()>0){
            for (int i = 0; i < pif.size(); i++) {
                PassengerInfo passengerinfo  = pif.get(i);
                String pst = passengerinfo.getCjrlx();  //乘机人类型   1成人，2儿童，3婴儿
                //如果乘机人 类型是0的情况下的话  默认的把他当成人来计算
                if("0".equals(pst)){

                    pst = "1";

                }



                double psp = passengerinfo.getPj();  //乘机人销售价  票价
                double aif = passengerinfo.getJj();  //机场建设费
                double ptx = passengerinfo.getRy();   //燃油税
                double ipr = passengerinfo.getBxdj();  //保险单价
                int inu = passengerinfo.getBxfs();  //保险分数
                //double rwm = passengerinfo.getRwm();


                JbInfo jbxx = goresponse2.getJbxx();
                if(jbxx!=null){
                    double psf = jbxx.getPsf();
                    if(0!=psf){
                        goTicketDetailPrice2.setJourneyPrice(psf);
                    }



                }


                double pfe = passengerinfo.getFwf();    //服务费

                goTicketDetailPrice2.setInsuranceCount(inu);
                ;
                if("1".equals(pst)){

                    //goTicketDetailPrice2.setFandianPriceAdult(rwm);  //只有成人的有返点金额
                    goTicketDetailPrice2.setTicketPriceAdult(psp);
                    goTicketDetailPrice2.setFlightAdultBulider(aif);
                    goTicketDetailPrice2.setFlightAdultFuel(ptx);
                    goTicketDetailPrice2.setServicePrice(pfe);
                    //这里的保险费用 已经计算了分数了的 柴说的
                    double insuranceprice = Arith.mul(ipr, 1);
                    if(insuranceprice!=0){
                        goTicketDetailPrice2.setInsurancePriceAdult(insuranceprice);  //成人的保险价格
                        insuranceadultcount++;

                    }







                    adultcount++;

                }else if("2".equals(pst)){

                    goTicketDetailPrice2.setTicketPriceChildren(psp);
                    goTicketDetailPrice2.setFlightChildrenBulider(aif);
                    goTicketDetailPrice2.setFlightChildrenFuel(ptx);
                    goTicketDetailPrice2.setChildrenServicePrice(pfe);

                    double insuranceprice = Arith.mul(ipr, 1);
                    if(insuranceprice!=0){
                        goTicketDetailPrice2.setInsurancePriceChildren(insuranceprice);  //成人的保险价格
                        insurancechildrencount++;

                    }



                    childrencount++;
                }else if("3".equals(pst)){
                    goTicketDetailPrice2.setTicketPriceBady(psp);
                    goTicketDetailPrice2.setFlightBadyBulider(aif);
                    goTicketDetailPrice2.setFlightBadyFuel(ptx);
                    goTicketDetailPrice2.setBabyServicePrice(pfe);
                    double insuranceprice = Arith.mul(ipr, 1);
                    if(insuranceprice!=0){
                        goTicketDetailPrice2.setInsurancePriceBaby(insuranceprice);  //成人的保险价格
                        insurancebabycount++;

                    }


                    babycount++;
                }
            }
        }
        goTicketDetailPrice2.setAdultCount(adultcount);
        goTicketDetailPrice2.setChildrenCount(childrencount);
        goTicketDetailPrice2.setBadyCount(babycount);

        goTicketDetailPrice2.setInsurancePriceAdultCount(insuranceadultcount);
        goTicketDetailPrice2.setInsurancePriceChildrenCount(insurancechildrencount);
        goTicketDetailPrice2.setInsurancePriceBabyCount(insurancebabycount);

        double flightpriceadulttal = Arith.mul(goTicketDetailPrice2.getTicketPriceAdult(),goTicketDetailPrice2.getAdultCount());
        double flightpricechildrental = Arith.mul(goTicketDetailPrice2.getTicketPriceChildren(),goTicketDetailPrice2.getChildrenCount());
        double flightpricebabytal = Arith.mul(goTicketDetailPrice2.getTicketPriceBady(),goTicketDetailPrice2.getBadyCount());


        double flightpricetal = Arith.add(flightpriceadulttal, Arith.add(flightpricechildrental,flightpricebabytal));                //机票的票价总计


        double  flightAdultBuliderAndFuel =  Arith.mul( Arith.add(goTicketDetailPrice2.getFlightAdultBulider(),goTicketDetailPrice2.getFlightAdultFuel()),goTicketDetailPrice2.getAdultCount()) ;

        double  flightChildrenBuliderAndFuel =  Arith.mul( Arith.add(goTicketDetailPrice2.getFlightChildrenBulider(),goTicketDetailPrice2.getFlightChildrenFuel()),goTicketDetailPrice2.getChildrenCount()) ;

        double  flightBabyBuliderAndFuel =  Arith.mul( Arith.add(goTicketDetailPrice2.getFlightBadyBulider(),goTicketDetailPrice2.getFlightBadyFuel()),goTicketDetailPrice2.getBadyCount()) ;

        double flighBuliderAndFuelTal = Arith.add(flightAdultBuliderAndFuel, Arith.add(flightChildrenBuliderAndFuel, flightBabyBuliderAndFuel));  //基建 燃油的价格总计




        double adultinsurance = Arith.mul(goTicketDetailPrice2.getInsurancePriceAdult(),goTicketDetailPrice2.getInsurancePriceAdultCount());  //成人的保险价格合计
        double childreninsurance = Arith.mul(goTicketDetailPrice2.getInsurancePriceChildren(),goTicketDetailPrice2.getInsurancePriceChildrenCount());  //儿童的保险的价格
        double babyinsurance = Arith.mul(goTicketDetailPrice2.getInsurancePriceBaby(),goTicketDetailPrice2.getInsurancePriceBabyCount());  //婴儿的保险价格
        //去程保险费用合计

        double insurancetal = Arith.add(adultinsurance, Arith.add(childreninsurance,babyinsurance));
        double goServiceAdult  = 0;

        double adultservice =     Arith.mul(goTicketDetailPrice2.getServicePrice(), goTicketDetailPrice2.getAdultCount());      //成人的服务费
        double childrenservice =     Arith.mul(goTicketDetailPrice2.getChildrenServicePrice(), goTicketDetailPrice2.getChildrenCount());      //成人的服务费

        double babyservice =     Arith.mul(goTicketDetailPrice2.getBabyServicePrice(), goTicketDetailPrice2.getBadyCount());      //成人的服务费
        //服务费  费用合计

        goServiceAdult =  Arith.add( adultservice, Arith.add(childrenservice,babyservice))    ;

      /*  if(CacheFlightCommonData.flightisinternational){
            //如果是国际票的情况下的话


        }else{
            goServiceAdult  = Arith.mul(goTicketDetailPrice2.getServicePrice(), Arith.add(goTicketDetailPrice2.getAdultCount(),Arith.add(goTicketDetailPrice2.getChildrenCount(),goTicketDetailPrice2.getBadyCount())));  //服务费的总金额

        }*/


        goTicketDetailPrice2.setTicketPriceTal(flightpricetal);      //设置票价总价
        goTicketDetailPrice2.setFlightBadyBuliderAndFuelTal(flighBuliderAndFuelTal);     //设置基建税费的总价
        goTicketDetailPrice2.setInsurancePriceTal(insurancetal) ;      //设置保险的额总价格;
        goTicketDetailPrice2.setServicePriceTal(goServiceAdult);   // 服务费总价
        //机票优惠券金额
        if (goresponse2.getJbxx()!=null) {
            String jpyhje = goresponse2.getJbxx().getJpyhje();
            if (!TextUtils.isEmpty(jpyhje)) {
                double jcount =0;
                jcount = -Double.valueOf(jpyhje);
                goTicketDetailPrice2.setJcount(jcount);
            }
        }

    }
    public static ArrayList<PriceInfo> getOrderDetailPriceDatas( FlightTicketDetailPrice goTicketDetailPrice) {
        ArrayList<PriceInfo> dataList = new ArrayList<PriceInfo>();











        PriceInfo jiageprice = new PriceInfo();
//        if(CacheFlightCommonData.flightisinternational){
//            jiageprice.setName("票价");
//        }else{
            jiageprice.setName("票价(包含机建/燃油)");
//        }






        double goticketPriceTal = goTicketDetailPrice.getTicketPriceTal();     //
        double goflightBadyBuliderAndFuelTal = goTicketDetailPrice.getFlightBadyBuliderAndFuelTal();

        double goticketpriceallTal = Arith.add(goticketPriceTal,goflightBadyBuliderAndFuelTal);





        jiageprice.setTotalPrice(CacheFlightCommonData.flightisinternational?goticketPriceTal:goticketpriceallTal);
        ArrayList<PriceItem> pricejh = new ArrayList<PriceItem>();
   /*     PriceItem  goitem =new PriceItem();

        goitem.setType(1);

        if(orderdetailflighttravle_type == 1){
            goitem.setName("单程");
        }else if(orderdetailflighttravle_type ==2){
            goitem.setName("往返程");
        }else if(orderdetailflighttravle_type == 3){
            goitem.setName("多程");
        }
        pricejh.add(goitem);*/



        int goadultCount = goTicketDetailPrice.getAdultCount();
        if(goadultCount!=0){
            double ticketPriceAdult = goTicketDetailPrice.getTicketPriceAdult();
            double flightAdultBulider = goTicketDetailPrice.getFlightAdultBulider();
            double flightAdultFuel = goTicketDetailPrice.getFlightAdultFuel();


            addPriceItem(pricejh, goadultCount, "成人", FormatUtils.formatPrice(ticketPriceAdult));

            if(!CacheFlightCommonData.flightisinternational){
                addPriceItem(pricejh, goadultCount, "机建", FormatUtils.formatPrice(flightAdultBulider));
                addPriceItem(pricejh, goadultCount, CacheFlightCommonData.flightisinternational?"税费": "燃油", FormatUtils.formatPrice(flightAdultFuel));
            }






        }
        int gochildrenCount = goTicketDetailPrice.getChildrenCount();
        if(gochildrenCount!=0){
            double ticketPriceChildren = goTicketDetailPrice.getTicketPriceChildren();
            double flightChildrenBulider = goTicketDetailPrice.getFlightChildrenBulider();

            double flightChildrenFuel = goTicketDetailPrice.getFlightChildrenFuel();


            addPriceItem(pricejh, gochildrenCount, "儿童", FormatUtils.formatPrice(ticketPriceChildren));
            if(!CacheFlightCommonData.flightisinternational){

                addPriceItem(pricejh, gochildrenCount, "机建", FormatUtils.formatPrice(flightChildrenBulider));
                addPriceItem(pricejh, gochildrenCount, CacheFlightCommonData.flightisinternational?"税费": "燃油", FormatUtils.formatPrice(flightChildrenFuel));
            }


        }
        int gobadyCount = goTicketDetailPrice.getBadyCount();
        if(gobadyCount!=0){

            double  ticketpricebaby = goTicketDetailPrice.getTicketPriceBady();
            double flightBadyBulider = goTicketDetailPrice.getFlightBadyBulider();
            double flightBadyFuel = goTicketDetailPrice.getFlightBadyFuel();
            addPriceItem(pricejh, gobadyCount, "婴儿", FormatUtils.formatPrice(ticketpricebaby));
            if(!CacheFlightCommonData.flightisinternational){

                addPriceItem(pricejh, gobadyCount, "机建", FormatUtils.formatPrice(flightBadyBulider));
                addPriceItem(pricejh, gobadyCount,  CacheFlightCommonData.flightisinternational?"税费": "燃油", FormatUtils.formatPrice(flightBadyFuel));
            }



        }





        jiageprice.setFjjh(pricejh);
        dataList.add(jiageprice);

        if(CacheFlightCommonData.flightisinternational){
            //如果是国际的情况下的话
            PriceInfo sfjiageprice = new PriceInfo();
            sfjiageprice.setName("税费");

            sfjiageprice.setTotalPrice(goflightBadyBuliderAndFuelTal);
            ArrayList<PriceItem> sfpricejh = new ArrayList<PriceItem>();

            if(goadultCount!=0){
                double flightAdultFuel = goTicketDetailPrice.getFlightAdultFuel();
                addPriceItem(sfpricejh, goadultCount, "成人", FormatUtils.formatPrice(flightAdultFuel));
            }

            if(gochildrenCount!=0){
                double flightChildrenFuel = goTicketDetailPrice.getFlightChildrenFuel();
                addPriceItem(sfpricejh, gochildrenCount, "儿童", FormatUtils.formatPrice(flightChildrenFuel));

            }
            if(gobadyCount!=0){

                double flightBadyFuel = goTicketDetailPrice.getFlightBadyFuel();
                addPriceItem(sfpricejh, gobadyCount, "婴儿", FormatUtils.formatPrice(flightBadyFuel));
            }
            sfjiageprice.setFjjh(sfpricejh);
            dataList.add(sfjiageprice);
        }




        PriceInfo fwfpriceinfo = new PriceInfo();


        int totalcount = goTicketDetailPrice.getAdultCount()+goTicketDetailPrice.getChildrenCount()+goTicketDetailPrice.getBadyCount();

        fwfpriceinfo.setName("服务费"+"("+totalcount+")人");
        double servicetalprice = 0;

        servicetalprice = Arith.add(goTicketDetailPrice.getServicePriceTal(),servicetalprice);
        if(servicetalprice>0){

            fwfpriceinfo.setTotalPrice(servicetalprice);

            ArrayList<PriceItem> fwffjjh = new ArrayList<PriceItem>();


        /*if("1".equals(serviceType)){
            priceitem.setName("每人每航段收取");
        }else{
            priceitem.setName("每人收取");
        }*/

            // if(CacheFlightCommonData.flightisinternational){

            ArrayList<PriceItem> servicespriceitem = new ArrayList<PriceItem>();


            double adultservice =     Arith.mul(goTicketDetailPrice.getServicePrice(), goTicketDetailPrice.getAdultCount());      //成人的服务费
            if(adultservice>0){
                addPriceItem(fwffjjh, goTicketDetailPrice.getAdultCount(), "成人服务费", FormatUtils.formatPrice(goTicketDetailPrice.getServicePrice()));
            }



            double childrenservice =     Arith.mul(goTicketDetailPrice.getChildrenServicePrice(), goTicketDetailPrice.getChildrenCount());      //成人的服务费


            if(childrenservice>0){
                addPriceItem(fwffjjh, goTicketDetailPrice.getChildrenCount(), "儿童服务费", FormatUtils.formatPrice(goTicketDetailPrice.getChildrenServicePrice()));

            }


            double babyservice =     Arith.mul(goTicketDetailPrice.getBabyServicePrice(), goTicketDetailPrice.getBadyCount());      //成人的服务费
            if(babyservice>0){
                addPriceItem(fwffjjh, goTicketDetailPrice.getBadyCount(), "婴儿服务费", FormatUtils.formatPrice(goTicketDetailPrice.getBabyServicePrice()));

            }


         /*   }else{

                PriceItem  priceitem = new PriceItem();

                priceitem.setType(1);
                //设置 服务费 显示
                priceitem.setName("每人收取");
                double servicedanjia = 0;


                servicedanjia = Arith.add(goTicketDetailPrice.getServicePrice(),servicedanjia);

                priceitem.setUnitPrice(FormatUtils.formatPrice(servicedanjia));
                fwffjjh.add(priceitem);
            }*/

            fwfpriceinfo.setFjjh(fwffjjh);

            dataList.add(fwfpriceinfo);

        }




        double insurancetal = 0;

        insurancetal = Arith.add(goTicketDetailPrice.getInsurancePriceTal(),insurancetal);

        if(insurancetal>0){

            PriceInfo bxpriceinfo = new PriceInfo();
            bxpriceinfo.setName("保险");

            bxpriceinfo.setTotalPrice(insurancetal);
/*
            ArrayList<PriceItem> bxxiPriceitemInfos = getBxxiPriceitemInfos();




            bxpriceinfo.setFjjh(bxxiPriceitemInfos);*/
            dataList.add(bxpriceinfo);

        }

        double journeyPrice = goTicketDetailPrice.getJourneyPrice();
        if(journeyPrice!=0){
            //如果行程单价格不为 0 的情况下的话
            PriceInfo journeyprice = new PriceInfo();
            journeyprice.setName("配送费");
            journeyprice.setTotalPrice(journeyPrice);
            dataList.add(journeyprice);



        }
        double fandianPriceTal = goTicketDetailPrice.getFandianPriceTal();
        if(fandianPriceTal>0){
            PriceInfo fandianprice = new PriceInfo();
            // fandianprice.setName("优惠金额");
            //  fandianprice.setTotalPrice(fandianPriceTal);
            fandianprice.setExplain("优惠 ¥"+ FormatUtils.formatPrice(fandianPriceTal));
            dataList.add(fandianprice);
        }
        //机票优惠券金额
        double jpyhje = goTicketDetailPrice.getJcount();
        if (jpyhje!=0){
            PriceInfo jpyhInfo = new PriceInfo();
            jpyhInfo.setName("优惠券");
            jpyhInfo.setTotalPrice(jpyhje);
            dataList.add(jpyhInfo);
        }

        return dataList;



    }
    private  static void addPriceItem(ArrayList<PriceItem> pricejh, int goadultCount, String name, String unitPrice) {
        PriceItem goadultitem = new PriceItem();

        goadultitem.setType(1);
        goadultitem.setName(name);
        if (!TextUtils.isEmpty(unitPrice)){
            Double aDouble = Double.valueOf(unitPrice);
            goadultitem.setUnitPrice(aDouble);
        }
        goadultitem.setNumber(goadultCount);
        try{
            Double aDouble = Double.valueOf(unitPrice);
            if(aDouble!=0){
                pricejh.add(goadultitem);
            }
        }catch (Exception ption){
            pricejh.add(goadultitem);
        }

    }

}
