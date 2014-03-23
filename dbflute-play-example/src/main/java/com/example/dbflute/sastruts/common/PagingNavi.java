/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.example.dbflute.sastruts.common;

import java.io.Serializable;
import java.util.List;

import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.pagenavi.PageNumberLink;
import org.seasar.dbflute.cbean.pagenavi.PageNumberLinkSetupper;

/**
 * ページングナビゲーション構築オブジェクト。<br />
 * /WEB-INF/view/common/paging_navi.jsp を利用したページングの際に利用する。<br/>
 * このクラスのインスタンス変数名は pagingNavi であること。<br />
 * @author mokkouyou (initial making)
 * @author jflute (extends it)
 */
public class PagingNavi implements Serializable {

    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    public boolean displayPagingNavi;
    public int allRecordCount;
    public int allPageCount;
    public int currentPageNumber;
    public String prePageLinkHref;
    public String nextPageLinkHref;
    public boolean existPrePage;
    public boolean existNextPage;
    public List<PageNumberLink> pageNumberLinkList;
    public int pageNumberLinkIndex;

    // ===================================================================================
    //                                                                                Main
    //                                                                                ====
    /**
     * Prepare paging navigation.
     * @param page The select page as bean of paging result. (NotNull)
     * @param linkPaths The varying array of link paths. (NotNull, EmptyAllowed)
     */
    public void prepare(PagingResultBean<?> page, Object... linkPaths) {
        displayPagingNavi = !page.isEmpty();

        allRecordCount = page.getAllRecordCount();
        currentPageNumber = page.getCurrentPageNumber();
        allPageCount = page.getAllPageCount();
        existPrePage = page.isExistPrePage();
        existNextPage = page.isExistNextPage();

        nextPageLinkHref = createTargetPageNumberLink(currentPageNumber + 1, linkPaths);
        prePageLinkHref = createTargetPageNumberLink(currentPageNumber - 1, linkPaths);
        pageNumberLinkList = createPageNumberLinkList(page, linkPaths);
    }

    /**
     * Create the list of page number link. <br />
     * @param pagingResult The bean of paging result. (NotNull)
     * @param linkPaths The array of like paths. (NotNull)
     * @return The list of page number link. (NotNull)
     */
    protected List<PageNumberLink> createPageNumberLinkList(final PagingResultBean<?> pagingResult,
            final Object[] linkPaths) {
        pagingResult.setPageRangeSize(3); // 本当はコンフィグなどから取得するのが好ましい by jflute
        PageNumberLinkSetupper<PageNumberLink> setupper = new PageNumberLinkSetupper<PageNumberLink>() {
            public PageNumberLink setup(int pageNumberElement, boolean current) {
                String targetPageNumberLink = createTargetPageNumberLink(pageNumberElement, linkPaths);
                return new PageNumberLink().initialize(pageNumberElement, current, targetPageNumberLink);
            }
        };
        return pagingResult.pageRange().buildPageNumberLinkList(setupper);
    }

    /**
     * Create target page number link.
     * @param pageNumber Target page number.
     * @param linkPaths The array of like paths. (NotNull)
     * @return The link expression for target page. (NotNull)
     */
    protected String createTargetPageNumberLink(int pageNumber, Object[] linkPaths) { // ここはアプリによって色々かと by jflute
        StringBuilder sb = new StringBuilder();
        if (linkPaths != null && linkPaths.length > 0) {
            for (Object path : linkPaths) {
                sb.append(path).append("/");
            }
        }
        return sb.toString() + pageNumber + "/";
    }
}
