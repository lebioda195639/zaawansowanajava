package com.zjava.model.elements;

import com.zjava.api.GetData;
import com.zjava.repository.elements.AircraftTypeRepository;
import com.zjava.service.elements.AircraftService;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Adrian on 2017-06-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@PropertySource("classpath:application-test.properties ")
@Log4j2
public class AircraftTypeTest {
    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private AircraftTypeRepository aircraftTypeRepository;

    @Before
    public void beforeTests() {

    }

    @After
    public void afterTests() {

    }

    @Test
    public void testFindAll() throws Exception {
        GetData getData = new GetData();
        List<AircraftType> fromApi = getData.getObjectsList(new AircraftType(), AircraftType.class,  "v1", "aircraftTypes");
        for(AircraftType aircraftType : fromApi) {
            aircraftService.save(aircraftType);
        }
        List<AircraftType> fromCRUD = aircraftService.findAll();
        long count = aircraftService.count();
        assertEquals(fromApi.size(), fromCRUD.size());
    }

    @Test
    public void testCount() throws Exception {
        long a = aircraftService.count();
        System.out.println();
    }
}
