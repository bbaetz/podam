package uk.co.jemos.podam.test.unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import org.powermock.api.mockito.mockpolicies.Slf4jMockPolicy;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.LoggerFactory;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(PowerMockRunner.class)
@MockPolicy(Slf4jMockPolicy.class)
public class PrivateSetterPojoTest {
	@Test
	public void testPrivateAccessors(){
		PodamFactory factory = new PodamFactoryImpl();
		PrivateSetterPojo pojo = factory.manufacturePojo(PrivateSetterPojo.class);
		Assert.assertNotNull(pojo);
		Assert.assertNotNull(pojo.getValue());
		verify(LoggerFactory.getLogger(PodamFactoryImpl.class.getName())).warn(anyString(), eq("setValue"));
	}
}
