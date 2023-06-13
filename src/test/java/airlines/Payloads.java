package airlines;

import airlines.pojos.Airline;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import utils.DateUtils;
import utils.ERandomDataTypeNames;
import utils.RandomDataGenerator;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static String createAirlinePayloadFromString(String id, String name, String country,
                                                        String logo, String slogan, String head_quaters,
                                                        String website, String established) {
        String payload = "{\n" +
                "    \"id\": " + id + ",\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"country\": \"" + country + "\",\n" +
                "    \"logo\": \"" + logo + "\",\n" +
                "    \"slogan\": \"" + slogan + "\",\n" +
                "    \"head_quaters\": \"" + head_quaters + "\",\n" +
                "    \"website\": \"" + website + "\",\n" +
                "    \"established\": \"" + established + "\",\n" +
                "}";
        return payload;

    }

    public static Map<String, Object> createAirlinePayloadFromMap(String id, String name, String country,
                                                                  String logo, String slogan, String head_quaters,
                                                                  String website, String established) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", id);
        payload.put("name", name);
        payload.put("country", country);
        payload.put("logo", logo);
        payload.put("slogan", slogan);
        payload.put("head_quaters", head_quaters);
        payload.put("website", website);
        payload.put("established", established);

        return payload;
    }

    public static Map<String, Object> createAirlinePayloadFromMap() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", RandomDataGenerator.getRandomNumber(10));
        payload.put("name", RandomDataGenerator.getRandomDataFor(ERandomDataTypeNames.FIRSTNAME));
        payload.put("country", RandomDataGenerator.getRandomDataFor(ERandomDataTypeNames.COUNTRY));
        payload.put("logo", RandomDataGenerator.getRandomAlphabet(25));
        payload.put("slogan", RandomDataGenerator.getRandomAlphabet(10));
        payload.put("head_quaters", RandomDataGenerator.getRandomDataFor(ERandomDataTypeNames.CITYNAME));
        payload.put("website", RandomDataGenerator.getRandomWebsiteName());
        payload.put("established", RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear()));

        return payload;
    }

    public static Airline createAirlinePayloadFromPojo() {
        return Airline
                .builder()
                .id(Integer.parseInt(RandomDataGenerator.getRandomNumber(6)))
                .name(RandomDataGenerator.getRandomDataFor(ERandomDataTypeNames.FIRSTNAME))
                .country(RandomDataGenerator.getRandomDataFor(ERandomDataTypeNames.COUNTRY))
                .logo(RandomDataGenerator.getRandomAlphabet(25))
                .slogan(RandomDataGenerator.getRandomAlphabet(10))
                .head_quaters(RandomDataGenerator.getRandomDataFor(ERandomDataTypeNames.CITYNAME))
                .website(RandomDataGenerator.getRandomWebsiteName())
                .established(String.valueOf(RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear())))
                .build();
    }
}
