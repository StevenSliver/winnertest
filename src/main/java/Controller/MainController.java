package Controller;

        import com.alibaba.fastjson.JSONArray;
        import com.alibaba.fastjson.JSONObject;
        import model.User;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.ResponseBody;
        import org.springframework.web.servlet.ModelAndView;
        import dao.IUserServiceDao;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

        import java.util.List;

/**
 * Created by Steven Sliver on 2018/5/29.
 */
@Controller
public class MainController  extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private IUserServiceDao userService;

    public static final String INDEX = "index";

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response) {

        User user = new User();
        user.setName("shichao");
        user.setPhone("15877915057");
//        System.out.print("++++++++++++++++++++++"+user.toString());
        logger.debug("++++++++++++++++++++++"+user.toString());
        userService.addUser(user);

        List<User> userList = userService.getUserByPhone("15877915057");
//        System.out.println("\n......" + userList.size());
        logger.debug("......" + userList.size());

        JSONArray json = new JSONArray();
        JSONObject jsonres = new JSONObject();
        for(int i=0;i<userList.size();i++){
            json.add(userList.get(i));
        }
        jsonres.put("list",json);
        logger.debug("Json=["+json.toString()+"]");
//        return innerCreateModelAndView(INDEX);
        return "<html><body><h2>"+jsonres.toString()+"</h2></body></html>";
    }


    @RequestMapping("/jsonsource")
   //@RequestBody 将json对象转成java对象
   //@ResponseBody 表示返回的是json对象
    public @ResponseBody User jsonSource(@RequestBody User user){

        logger.debug("=========name="+user.getName());
        logger.debug("=========phone="+user.getPhone());
        return user;
    }

    @RequestMapping("/kvsource")
    public @ResponseBody User kvSource(User user){
        logger.debug("=========name="+user.getName());
        logger.debug("=========phone="+user.getPhone());
        return user;
    }


    @RequestMapping(value = "/jsonsource_1",produces="application/json; charset=utf-8")
    public @ResponseBody User jsonSource_1(@RequestBody User user){
        String name = user.getName();
        String phong = user.getPhone();
        logger.debug("=========name="+user.getName());
        logger.debug("=========phone="+user.getPhone());
        user.setName(name+"_change");
        user.setPhone(phong+"_change");
        return user;
    }

}
