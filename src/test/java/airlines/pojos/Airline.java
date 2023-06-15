package airlines.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poiji.annotation.ExcelCellName;
import lombok.*;
import utils.DateUtils;
import utils.ERandomDataTypeNames;
import utils.RandomDataGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airline {
    private int id = Integer.parseInt(RandomDataGenerator.getRandomNumber(6));

    @ExcelCellName("Id")
    @JsonIgnore
    private String idValue;
    @ExcelCellName("Name")
    private String name = RandomDataGenerator.getRandomDataFor(ERandomDataTypeNames.FIRSTNAME);
    @ExcelCellName("Country")
    private String country = RandomDataGenerator.getRandomDataFor(ERandomDataTypeNames.COUNTRY);
    @ExcelCellName("Logo")
    private String logo = RandomDataGenerator.getRandomAlphabet(25);
    @ExcelCellName("Slogan")
    private String slogan = RandomDataGenerator.getRandomAlphabet(10);
    @ExcelCellName("HeadQuarter")
    private String head_quaters = RandomDataGenerator.getRandomDataFor(ERandomDataTypeNames.CITYNAME);
    @ExcelCellName("Website")
    private String website = RandomDataGenerator.getRandomWebsiteName();
    @ExcelCellName("Established")
    private String established = String.valueOf(RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear()));

}
