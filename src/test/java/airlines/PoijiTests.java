package airlines;

import airlines.pojos.AirlinePoiji;
import com.poiji.bind.Poiji;

import java.io.File;
import java.util.List;

public class PoijiTests {
    public static void main(String[] args) {
        List<AirlinePoiji> data = Poiji.fromExcel(new File("src/test/resources/testData/createAirlineData.xlsx"),AirlinePoiji.class);
    }
}
