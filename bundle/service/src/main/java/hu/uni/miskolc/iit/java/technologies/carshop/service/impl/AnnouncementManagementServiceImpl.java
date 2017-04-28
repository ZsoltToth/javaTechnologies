package hu.uni.miskolc.iit.java.technologies.carshop.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import hu.uni.miskolc.iit.java.technologies.carshop.api.model.Announcement;
import hu.uni.miskolc.iit.java.technologies.carshop.api.model.Car;
import hu.uni.miskolc.iit.java.technologies.carshop.api.model.Price;
import hu.uni.miskolc.iit.java.technologies.carshop.api.service.AnnouncementManagementService;
import hu.uni.miskolc.iit.java.technologies.carshop.service.dao.AnnouncementDAO;

public class AnnouncementManagementServiceImpl implements AnnouncementManagementService {
	
	private AnnouncementDAO announcementDAO;
	
	

	public AnnouncementManagementServiceImpl(AnnouncementDAO announcementDAO) {
		super();
		this.announcementDAO = announcementDAO;
	}

	public Collection<Announcement> listAnnouncements() {
		return announcementDAO.readAnnouncements();
	}

	public Collection<Announcement> listOpenAnnouncements() {
		Collection<Announcement> result = new ArrayList<Announcement>();
		for(Announcement announcement : announcementDAO.readAnnouncements()){
			if(announcement.isOpenAnnouncement()){
				result.add(announcement);
			}
		}
		return result;
	}

	public void announce(Car car, Date expire, Price price) {
		Announcement announcement = new Announcement(car, price, new Date(), expire, false);
		announcementDAO.createAnnouncement(announcement);

	}

}
