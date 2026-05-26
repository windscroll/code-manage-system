package com.code.mapper;

import com.code.entity.TreeNode;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TreeNodeMapper {
    List<TreeNode> getAllNode();
    void addNode(TreeNode treeNode);
    void editNode(TreeNode treeNode);
    void deleteNode(@Param("id") Integer id);
}