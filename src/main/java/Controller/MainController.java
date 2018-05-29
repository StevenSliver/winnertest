package Controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    private IUserServiceDao userService;

    public static final String INDEX = "index";

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {

        User user = new User();
        user.setName("shichao");
        user.setPhone("15877915057");
        System.out.print("++++++++++++++++++++++"+user.toString());
        userService.addUser(user);

        List<User> userList = userService.getUserByPhone("18811721028");
        System.out.println("......" + userList.size());

        return innerCreateModelAndView(INDEX);
    }
}
