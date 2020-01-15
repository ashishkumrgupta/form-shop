package com.farmershop.initializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.farmershop.initializer.db.FlockDB;
import com.farmershop.initializer.db.FlockFactory;
import com.farmershop.initializer.db.FlockSexType;
import com.farmershop.initializer.db.FlockType;
import com.farmershop.initializer.db.Goat;
import com.farmershop.initializer.db.Lamb;
import com.farmershop.initializer.db.OrderDB;
import com.farmershop.initializer.db.Sheep;

/**
 * Initializer method, which executes at run time and load the data from the
 * provided input flock.xml
 * 
 * @author Ashish
 *
 */
@Component
public class FarmShopDataInitializer implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(FarmShopDataInitializer.class);

	private static final String SEX = "sex";
	private static final String NAME = "name";
	private static final String WOOL = "wool";

	@Autowired
	ResourceLoader resourceLoader;

	private static FlockDB flockDB;
	private static OrderDB orderDB;

	public static FlockDB getFlockDB() {
		return flockDB;
	}

	public static OrderDB getOrderDB() {
		return orderDB;
	}

	@Override
	public void run(String... args) throws Exception {
		Resource resource = resourceLoader.getResource("classpath:flock.xml");
		InputStream stream = resource.getInputStream();
		LOGGER.info("Loading of input data started.");
		parseFlockXMLAndPopulateDBs(stream);
		LOGGER.info("Loading of input data done.");
	}

	private static void parseFlockXMLAndPopulateDBs(InputStream stream)
			throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(stream);

		NodeList nListOfSheep = document.getElementsByTagName(FlockType.SHEEP.name().toLowerCase());
		LOGGER.info("total Sheeps: {}", nListOfSheep.getLength());
		NodeList nListOfGoat = document.getElementsByTagName(FlockType.GOAT.name().toLowerCase());
		LOGGER.info("total goats: {}", nListOfGoat.getLength());
		NodeList nListOfLamb = document.getElementsByTagName(FlockType.LAMB.name().toLowerCase());
		LOGGER.info("total lambs: {}", nListOfLamb.getLength());

		flockDB = new FlockDB(parseSheeps(nListOfSheep), parseGoats(nListOfGoat), parseLambs(nListOfLamb));
		flockDB.setTotalMilk(findAvailableMilk(flockDB));
		flockDB.setTotalWool(findAvailableWool(flockDB));

		orderDB = new OrderDB();
	}

	/**
	 * Method to parse sheep Objects.
	 * 
	 * @param nListOfSheep {@link NodeList}
	 * @return list of Sheep POJO objects.
	 */
	private static List<Sheep> parseSheeps(NodeList nListOfSheep) {
		List<Sheep> sheeps = new ArrayList<>();
		for (int i = 0; i < nListOfSheep.getLength(); i++) {
			Node node = nListOfSheep.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String name = eElement.getAttribute(NAME);
				String sex = eElement.getAttribute(SEX);
				String wool = eElement.getAttribute(WOOL);
				Sheep sheep = (Sheep) FlockFactory.getFlock(FlockType.SHEEP.name(), sex);
				sheep.setName(name);
				sheep.setWoolQuanity(Double.parseDouble(wool));
				sheeps.add(sheep);
			}
		}
		return sheeps;
	}

	/**
	 * Method to parse goat Objects.
	 * 
	 * @param nListOfGoats {@link NodeList}
	 * @return list of Goat POJO objects.
	 */
	private static List<Goat> parseGoats(NodeList nListOfGoats) {
		List<Goat> goats = new ArrayList<>();
		for (int i = 0; i < nListOfGoats.getLength(); i++) {
			Node node = nListOfGoats.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String name = eElement.getAttribute(NAME);
				String sex = eElement.getAttribute(SEX);

				Goat goat = (Goat) FlockFactory.getFlock(FlockType.GOAT.name(), sex);
				goat.setName(name);
				goats.add(goat);
			}
		}
		return goats;
	}

	/**
	 * Method to parse Lamb Objects.
	 * 
	 * @param nListOfLambs {@link NodeList}
	 * @return list of Lamb POJO objects.
	 */
	private static List<Lamb> parseLambs(NodeList nListOfLambs) {
		List<Lamb> lambs = new ArrayList<>();
		for (int i = 0; i < nListOfLambs.getLength(); i++) {
			Node node = nListOfLambs.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String name = eElement.getAttribute(NAME);
				String sex = eElement.getAttribute(SEX);
				String wool = eElement.getAttribute(WOOL);
				Lamb lamb = (Lamb) FlockFactory.getFlock(FlockType.LAMB.name(), sex);

				lamb.setName(name);
				lamb.setWoolQuanity(Double.parseDouble(wool));
				lambs.add(lamb);
			}
		}
		return lambs;
	}

	/**
	 * To find available milk in the stock.
	 * 
	 * @param stock {@link FlockDB} Working as a Database for stock.
	 * @return available milk in the stock
	 */
	private static double findAvailableMilk(FlockDB stock) {

		List<Goat> goats = stock.getGoats();
		List<Sheep> sheeps = stock.getSheeps();

		double avaialbleGoatMilk = goats.stream().filter(g -> FlockSexType.F.getType().equalsIgnoreCase(g.getSex()))
				.mapToDouble(o -> o.getMilkQuantity()).sum();

		double avaialbleSheapMilk = sheeps.stream().filter(s -> FlockSexType.F.getType().equalsIgnoreCase(s.getSex()))
				.mapToDouble(o -> o.getMilkQuantity()).sum();

		return avaialbleGoatMilk + avaialbleSheapMilk;
	}

	/**
	 * To find available wool in the stock.
	 * 
	 * @param stock {@link FlockDB} Working as a Database for stock.
	 * @return available wool in the stock
	 */
	private static double findAvailableWool(FlockDB stock) {
		List<Sheep> sheeps = stock.getSheeps();
		List<Lamb> lambs = stock.getLambs();

		double avaialbleLambWool = lambs.stream().mapToDouble(lamb -> lamb.getWoolQuanity()).sum();
		double avaialbleSheapWool = sheeps.stream().mapToDouble(sheep -> sheep.getWoolQuanity()).sum();

		return avaialbleLambWool + avaialbleSheapWool;
	}
}