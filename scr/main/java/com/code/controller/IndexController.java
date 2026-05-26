package com.code.controller;

import com.code.entity.QuestionSolution;
import com.code.entity.SysUser;
import com.code.entity.TreeNode;
import com.code.service.IndexService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IndexController {

    @Resource
    private IndexService indexService;

    //管理员登录存入会话
    @PostMapping("/login")
    public Object login(@RequestBody SysUser user, HttpSession session){
        SysUser sysUser = indexService.login(user);
        if(sysUser != null){
            session.setAttribute("admin",sysUser);
            return true;
        }
        return false;
    }

    //判断是否为管理员
    @GetMapping("/isAdmin")
    public boolean isAdmin(HttpSession session){
        return session.getAttribute("admin") != null;
    }

    @GetMapping("/tree/list")
    public List<TreeNode> getTreeList(){
        return indexService.getTreeList();
    }

    //仅管理员才可执行的操作接口
    @PostMapping("/tree/add")
    public Object addNode(@RequestBody TreeNode treeNode,HttpSession session){
        if(session.getAttribute("admin") == null){
            return "无权限";
        }
        indexService.addNode(treeNode);
        return true;
    }

    @PostMapping("/tree/edit")
    public Object editNode(@RequestBody TreeNode treeNode,HttpSession session){
        if(session.getAttribute("admin") == null){
            return "无权限";
        }
        indexService.editNode(treeNode);
        return true;
    }

    @GetMapping("/tree/delete")
    public Object deleteNode(Integer id,HttpSession session){
        if(session.getAttribute("admin") == null){
            return "无权限";
        }
        indexService.deleteNode(id);
        return true;
    }

    @GetMapping("/solution/list")
    public List<QuestionSolution> getSolutionList(Integer nodeId){
        return indexService.getSolutionList(nodeId);
    }

    @PostMapping("/solution/save")
    public Object saveSolution(@RequestBody QuestionSolution solution,HttpSession session){
        if(session.getAttribute("admin") == null){
            return "无权限";
        }
        indexService.saveSolution(solution);
        return true;
    }

    @GetMapping("/solution/delete")
    public Object deleteSolution(Integer id,HttpSession session){
        if(session.getAttribute("admin") == null){
            return "无权限";
        }
        indexService.deleteSolution(id);
        return true;
    }
}