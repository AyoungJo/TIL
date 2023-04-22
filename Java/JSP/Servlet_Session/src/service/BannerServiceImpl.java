package service;

import java.util.List;

import dao.BannerDAO;
import dao.BannerDaoImpl;

public class BannerServiceImpl implements BannerService {

	@Override
	public List<String> listBanner() {
		BannerDAO bannerDao = new BannerDaoImpl();
		List<String> list = bannerDao.selectAll(); 
		return list;
	}

}
