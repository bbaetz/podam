package uk.co.jemos.podam.test.unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verify;
import org.powermock.api.mockito.mockpolicies.Slf4jMockPolicy;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.LoggerFactory;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @author daivanov
 *
 */
@RunWith(PowerMockRunner.class)
@MockPolicy(Slf4jMockPolicy.class)
public class PackagePrivatePojoTest {
	@Test
	public void testPackagePrivateClassInstantiation() {
		PodamFactory factory = new PodamFactoryImpl();
		PackagePrivatePojo pojo = factory.manufacturePojo(PackagePrivatePojo.class);
		Assert.assertNotNull(pojo);
		Assert.assertNotNull(pojo.getValue());
		verify(LoggerFactory.getLogger(PodamFactoryImpl.class.getName()), never()).warn(anyString(), eq("setValue"));
	}
}
