package com.boot.study.swagger;

/**
 * Created by hujh on 2018/4/8.
 */
public class ApiInfo2 {

    private String mtitle;
    private String ntitle;
    private String ver;
    private String url;
    private String author;
    private String linkText;
    private String site;

    public ApiInfo2() {
    }

    public ApiInfo2(String mtitle, String ntitle, String ver, String url, String author, String linkText, String site) {
        this.mtitle = mtitle;
        this.ntitle = ntitle;
        this.ver = ver;
        this.url = url;
        this.author = author;
        this.linkText = linkText;
        this.site = site;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
