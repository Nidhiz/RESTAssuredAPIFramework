package airlines.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.DateUtils;
import utils.ERandomDataTypeNames;
import utils.RandomDataGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Airline {
    private int id = Integer.parseInt(RandomDataGenerator.getRandomNumber(6));
    private String name = RandomDataGenerator.getRandomDataFor(ERandomDataTypeNames.FIRSTNAME);
    private String country = RandomDataGenerator.getRandomDataFor(ERandomDataTypeNames.COUNTRY);
    private String logo = RandomDataGenerator.getRandomAlphabet(25);
    private String slogan = RandomDataGenerator.getRandomAlphabet(10);
    private String head_quaters = RandomDataGenerator.getRandomDataFor(ERandomDataTypeNames.CITYNAME);
    private String website = RandomDataGenerator.getRandomWebsiteName();
    private String established = String.valueOf(RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear()));
}
