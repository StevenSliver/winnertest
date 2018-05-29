package Controller;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Steven Sliver on 2018/5/29.
 */
public class BaseController {
    /**
     * 生成视图，用于继承
     * @param view
     */
    protected ModelAndView innerCreateModelAndView (String view, Object... objects) {
        assert (objects.length % 2) == 0;
        Map<String, Object> modelMap = new HashMap<String, Object>();
        for (int i = 0; i < objects.length; i++) {
            String name = (String) objects[i++];
            modelMap.put(name, objects[i]);
        }
        return new ModelAndView(view, modelMap);
    }
}
