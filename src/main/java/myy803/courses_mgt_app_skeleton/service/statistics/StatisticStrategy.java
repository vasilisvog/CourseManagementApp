package myy803.courses_mgt_app_skeleton.service.statistics;

import myy803.courses_mgt_app_skeleton.entity.Course;

public interface StatisticStrategy {
	public double calculateStatistic(Course course);
}
