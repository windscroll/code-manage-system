package com.code.service;

import com.code.entity.QuestionSolution;
import com.code.entity.SysUser;
import com.code.entity.TreeNode;
import java.util.List;

public interface IndexService {
    SysUser login(SysUser user);
    List<TreeNode> getTreeList();
    void addNode(TreeNode treeNode);
    void editNode(TreeNode treeNode);
    void deleteNode(Integer id);
    List<QuestionSolution> getSolutionList(Integer nodeId);
    void saveSolution(QuestionSolution solution);
    void deleteSolution(Integer id);
}