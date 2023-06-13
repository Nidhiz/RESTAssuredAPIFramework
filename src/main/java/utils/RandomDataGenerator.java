package utils;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {
    public static Faker faker = new Faker();

    public static String getRandomDataFor(ERandomDataTypeNames dataTypeNames) {
        switch (dataTypeNames) {
            case FULLNAME:
                return faker.name().fullName();
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();
            case COUNTRY:
                return faker.address().country();
            case CITYNAME:
                return faker.address().cityName();
            default:
                return "Data type names not available";
        }
    }

    public static String getRandomNumber(int count) {
        return faker.number().digits(count);
    }

    public static String getRandomAlphabet(int size) {
        return RandomStringUtils.randomAlphabetic(size);
    }

    public static String getRandomWebsiteName() {
        return "https://" + RandomStringUtils.randomAlphabetic(10) + ".com";
    }

    public static int getRandomNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }
}
