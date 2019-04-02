package resources

import uk.co.jemos.podam.api.PodamFactory
import uk.co.jemos.podam.api.PodamFactoryImpl

class CommonData {
    static def times
    static List<?> getObjectsFromFactory(Class<?> type, List list, int maxTimes = 1000) {
        Random random = new Random()
        times = random.nextInt(maxTimes)
        PodamFactory factory = new PodamFactoryImpl()
        for (int i = 0; i < times; i++) {
            list.add(factory.manufacturePojo(type))
        }

        return list
    }
}
