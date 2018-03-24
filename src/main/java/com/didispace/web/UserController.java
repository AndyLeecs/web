package com.didispace.web;

import com.didispace.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/users")
public class UserController {
    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    //查询用户列表
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList(){
            List<User> r = new ArrayList<User>(users.values());
            return r;
        }

    //创建一个用户
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        users.put(user.getId(),user);
        return "success";
    }

    //根据id查询一个用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        //pathVariable指url中的id
        return users.get(id);
    }
    //根据id更新一个用户
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user){
        User u = users.get(id);
        u.setAge(user.getAge());
        u.setId(user.getId());
        u.setName(user.getName());
        users.put(id,u);
        return "success";
    }

    //根据id删除一个用户
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }
}
