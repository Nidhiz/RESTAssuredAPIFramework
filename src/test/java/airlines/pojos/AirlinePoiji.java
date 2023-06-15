package airlines.pojos;

import com.poiji.annotation.ExcelCellName;
import utils.DateUtils;
import utils.ERandomDataTypeNames;
import utils.RandomDataGenerator;

public class AirlinePoiji {
    @ExcelCellName("Id")
    private int id;
    @ExcelCellName("Name")
    private String name;
    @ExcelCellName("Country")
    private String country;
    @ExcelCellName("Logo")
    private String logo;
    @ExcelCellName("Slogan")
    private String slogan;
    @ExcelCellName("HeadQuarter")
    private String head_quaters;
    @ExcelCellName("Website")
    private String website;
    @ExcelCellName("Established")
    private String established;
}
