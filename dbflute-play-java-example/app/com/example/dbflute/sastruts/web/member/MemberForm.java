package com.example.dbflute.sastruts.web.member;

import java.util.Date;

import play.data.format.Formats.DateTime;
import play.data.validation.Constraints.Required;

import com.example.dbflute.sastruts.web.DoCreate;
import com.example.dbflute.sastruts.web.DoDelete;
import com.example.dbflute.sastruts.web.DoUpdate;

/**
 * @author mokkouyou (initial making)
 * @author jflute (extends it)
 */
public class MemberForm {

    @Required(groups = { DoCreate.class, DoUpdate.class })
    public String memberName;

    @Required(groups = { DoCreate.class, DoUpdate.class })
    public String memberAccount;

    @Required(groups = { DoCreate.class, DoUpdate.class })
    public String memberStatusCode;

    @DateTime(pattern = "yyyy/MM/dd")
    public Date birthdate;

    public String formalizedDate;

    public String latestLoginDatetime;

    public String updateDatetime;

    @Required(groups = { DoUpdate.class })
    public String previousStatusCode;

    @Required(groups = { DoUpdate.class, DoDelete.class })
    public String versionNo;

}
