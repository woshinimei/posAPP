package com.example.onedream.flightapp.bean;

public class FlightTicketDetailPrice {
	private double TicketPriceAdult;    //成人票价
	private double TicketPriceChildren;  //儿童票价
	private double TicketPriceBady;      //婴儿票价
	private double FlightAdultBulider;   //成人基建
	private double FlightAdultFuel;      //成人燃油
	private double FlightChildrenBulider;   //儿童基建
	private double FlightChildrenFuel;      //儿童燃油
	private double FlightBadyBulider;      //婴儿基建
	private double FlightBadyFuel;         //婴儿燃油
	private double InsurancePriceAdult;          //成人保险价格
	private double InsurancePriceChildren;      //儿童保险价格
	private double InsurancePriceBaby;          //婴儿保险价格


	private int InsurancePriceAdultCount;          //成人保险的人数
	private int InsurancePriceChildrenCount;      //儿童保险的人数
	private int InsurancePriceBabyCount;          //婴儿保险的人数


	private double servicePrice;                //成人服务费用
	private double childrenServicePrice;       //儿童服务费
	private double babyServicePrice;           //婴儿服务费

	private int adultCount;   //成人数量
	private int ChildrenCount;   //成人数量
	private int BadyCount;   //婴儿数量
	private int InsuranceCount;          //保险份数


	private String titlevalue;        //订单详 标题专用字段
	private double FandianPriceAdult;  //成人返点金额

	private double FandianPriceChildren;  //儿童返点金额
	private double FandianPriceBaby;  //婴儿返点金额


	private double TicketPriceTal;  //票价总价
	private double FlightBadyBuliderAndFuelTal;  //机建税费总价
	private double InsurancePriceTal;   //保险总价
	private double ServicePriceTal;      //服务费总价
	private double journeyPrice;            //行程单价格
	private double FandianPriceTal;          //返点奖励总金额
	private double jcount;//机票优惠券


	public FlightTicketDetailPrice() {
		super();
		
	}

	public double getJcount() {
		return jcount;
	}

	public void setJcount(double jcount) {
		this.jcount = jcount;
	}

	public String getTitlevalue() {
		return titlevalue;
	}

	public void setTitlevalue(String titlevalue) {
		this.titlevalue = titlevalue;
	}

	public double getFandianPriceAdult() {
		return FandianPriceAdult;
	}

	public void setFandianPriceAdult(double fandianPriceAdult) {
		FandianPriceAdult = fandianPriceAdult;
	}

	public double getFandianPriceChildren() {
		return FandianPriceChildren;
	}

	public void setFandianPriceChildren(double fandianPriceChildren) {
		FandianPriceChildren = fandianPriceChildren;
	}

	public double getFandianPriceBaby() {
		return FandianPriceBaby;
	}

	public void setFandianPriceBaby(double fandianPriceBaby) {
		FandianPriceBaby = fandianPriceBaby;
	}

	public double getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}
	public double getTicketPriceAdult() {
		return TicketPriceAdult;
	}
	public void setTicketPriceAdult(double ticketPriceAdult) {
		TicketPriceAdult = ticketPriceAdult;
	}
	public double getTicketPriceChildren() {
		return TicketPriceChildren;
	}
	public void setTicketPriceChildren(double ticketPriceChildren) {
		TicketPriceChildren = ticketPriceChildren;
	}
	public double getTicketPriceBady() {
		return TicketPriceBady;
	}
	public void setTicketPriceBady(double ticketPriceBady) {
		TicketPriceBady = ticketPriceBady;
	}
	public double getFlightAdultBulider() {
		return FlightAdultBulider;
	}
	public void setFlightAdultBulider(double flightAdultBulider) {
		FlightAdultBulider = flightAdultBulider;
	}
	public double getFlightAdultFuel() {
		return FlightAdultFuel;
	}
	public void setFlightAdultFuel(double flightAdultFuel) {
		FlightAdultFuel = flightAdultFuel;
	}
	public double getFlightChildrenBulider() {
		return FlightChildrenBulider;
	}
	public void setFlightChildrenBulider(double flightChildrenBulider) {
		FlightChildrenBulider = flightChildrenBulider;
	}
	public double getFlightChildrenFuel() {
		return FlightChildrenFuel;
	}
	public void setFlightChildrenFuel(double flightChildrenFuel) {
		FlightChildrenFuel = flightChildrenFuel;
	}
	public double getFlightBadyBulider() {
		return FlightBadyBulider;
	}
	public void setFlightBadyBulider(double flightBadyBulider) {
		FlightBadyBulider = flightBadyBulider;
	}
	public double getFlightBadyFuel() {
		return FlightBadyFuel;
	}
	public void setFlightBadyFuel(double flightBadyFuel) {
		FlightBadyFuel = flightBadyFuel;
	}




	public int getAdultCount() {
		return adultCount;
	}
	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}
	public int getChildrenCount() {
		return ChildrenCount;
	}
	public void setChildrenCount(int childrenCount) {
		ChildrenCount = childrenCount;
	}
	public int getBadyCount() {
		return BadyCount;
	}
	public void setBadyCount(int badyCount) {
		BadyCount = badyCount;
	}
	
	
	
	public int getInsuranceCount() {
		return InsuranceCount;
	}
	public void setInsuranceCount(int insuranceCount) {
		InsuranceCount = insuranceCount;
	}
	public double getJourneyPrice() {
		return journeyPrice;
	}
	public void setJourneyPrice(double journeyPrice) {
		this.journeyPrice = journeyPrice;
	}

	public double getInsurancePriceAdult() {
		return InsurancePriceAdult;
	}

	public void setInsurancePriceAdult(double insurancePriceAdult) {
		InsurancePriceAdult = insurancePriceAdult;
	}

	public double getInsurancePriceChildren() {
		return InsurancePriceChildren;
	}

	public void setInsurancePriceChildren(double insurancePriceChildren) {
		InsurancePriceChildren = insurancePriceChildren;
	}

	public double getInsurancePriceBaby() {
		return InsurancePriceBaby;
	}

	public void setInsurancePriceBaby(double insurancePriceBaby) {
		InsurancePriceBaby = insurancePriceBaby;
	}

	public double getTicketPriceTal() {
		return TicketPriceTal;
	}

	public void setTicketPriceTal(double ticketPriceTal) {
		TicketPriceTal = ticketPriceTal;
	}

	public double getFlightBadyBuliderAndFuelTal() {
		return FlightBadyBuliderAndFuelTal;
	}

	public void setFlightBadyBuliderAndFuelTal(double flightBadyBuliderAndFuelTal) {
		FlightBadyBuliderAndFuelTal = flightBadyBuliderAndFuelTal;
	}

	public double getInsurancePriceTal() {
		return InsurancePriceTal;
	}

	public void setInsurancePriceTal(double insurancePriceTal) {
		InsurancePriceTal = insurancePriceTal;
	}

	public double getServicePriceTal() {
		return ServicePriceTal;
	}

	public void setServicePriceTal(double servicePriceTal) {
		ServicePriceTal = servicePriceTal;
	}

	public double getFandianPriceTal() {
		return FandianPriceTal;
	}

	public void setFandianPriceTal(double fandianPriceTal) {
		FandianPriceTal = fandianPriceTal;
	}


	public int getInsurancePriceAdultCount() {
		return InsurancePriceAdultCount;
	}

	public void setInsurancePriceAdultCount(int insurancePriceAdultCount) {
		InsurancePriceAdultCount = insurancePriceAdultCount;
	}

	public int getInsurancePriceChildrenCount() {
		return InsurancePriceChildrenCount;
	}

	public void setInsurancePriceChildrenCount(int insurancePriceChildrenCount) {
		InsurancePriceChildrenCount = insurancePriceChildrenCount;
	}

	public int getInsurancePriceBabyCount() {
		return InsurancePriceBabyCount;
	}

	public void setInsurancePriceBabyCount(int insurancePriceBabyCount) {
		InsurancePriceBabyCount = insurancePriceBabyCount;
	}

	public double getChildrenServicePrice() {
		return childrenServicePrice;
	}

	public void setChildrenServicePrice(double childrenServicePrice) {
		this.childrenServicePrice = childrenServicePrice;
	}

	public double getBabyServicePrice() {
		return babyServicePrice;
	}

	public void setBabyServicePrice(double babyServicePrice) {
		this.babyServicePrice = babyServicePrice;
	}
}
