package com.example.dbflute.sastruts.web.member;

import play.data.validation.Constraints.Required;

import com.example.dbflute.sastruts.web.DoCreate;
import com.example.dbflute.sastruts.web.DoDelete;
import com.example.dbflute.sastruts.web.DoUpdate;

/**
 * @author mokkouyou (initial making)
 * @author jflute (extends it)
 */
public class MemberForm {

    //    @Required(arg0 = @Arg(key = "会員名", resource = false))
    @Required(groups = { DoCreate.class, DoUpdate.class })
    public String memberName;

    //    @Required(arg0 = @Arg(key = "会員アカウント", resource = false))
    @Required(groups = { DoCreate.class, DoUpdate.class })
    public String memberAccount;

    //    @Required(arg0 = @Arg(key = "会員ステータス", resource = false))
    @Required(groups = { DoCreate.class, DoUpdate.class })
    public String memberStatusCode;

    //    @DateType(datePatternStrict = "yyyy/MM/dd", msg = @Msg(key = "errors.date", resource = true), arg0 = @Arg(key = "生年月日", resource = false))
    public String birthdate;

    public String formalizedDate;

    public String latestLoginDatetime;

    public String updateDatetime;

    @Required(groups = { DoUpdate.class })
    public String previousStatusCode;

    @Required(groups = { DoUpdate.class, DoDelete.class })
    public String versionNo;

}
