package myy803.courses_mgt_app_skeleton.service.statistics;

public class MeanStatisticStrategy   extends TemplateStatisticStrategy{
	public MeanStatisticStrategy() {
		super();
	}
	protected void doActualCalculation() {
		double mean= 	descriptiveStatistics.getMean();
		System.out.println("this is the mean " + mean);
	}

}
