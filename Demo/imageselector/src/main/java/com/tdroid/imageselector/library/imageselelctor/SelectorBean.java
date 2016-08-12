package com.tdroid.imageselector.library.imageselelctor;/**
 * Created by Administrator on 2016/3/23.
 */

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/23.
 * 描述:
 * 修改者:
 *
 * @author tianhongtao on 2016/3/23 09:18
 * @version 1.0 2016/3/23 09:18
 * @since 1.0
 */
public class SelectorBean implements Serializable {
    private String path;
    private String disc;
    private String name;
    private String size;
    private int imgId;

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    private boolean isAddTag=false;

    private boolean isChecked=false;

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public boolean isAddTag() {
        return isAddTag;
    }

    public void setIsAddTag(boolean isAddTag) {
        this.isAddTag = isAddTag;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String discription) {
        this.disc = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
