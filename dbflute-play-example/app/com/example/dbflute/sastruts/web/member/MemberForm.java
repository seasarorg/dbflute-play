package com.example.dbflute.sastruts.web.member;


/**
 * @author mokkouyou (initial making)
 * @author jflute (extends it)
 */
public class MemberForm {

    //    @Required(target = "doUpdate, doDelete")
    public String memberId;

    //    @Required(arg0 = @Arg(key = "会員名", resource = false))
    public String memberName;

    //    @Required(arg0 = @Arg(key = "会員アカウント", resource = false))
    public String memberAccount;

    //    @Required(arg0 = @Arg(key = "会員ステータス", resource = false))
    public String memberStatusCode;

    //    @DateType(datePatternStrict = "yyyy/MM/dd", msg = @Msg(key = "errors.date", resource = true), arg0 = @Arg(key = "生年月日", resource = false))
    public String birthdate;

    public String formalizedDate;

    public String latestLoginDatetime;

    public String updateDatetime;

    //    @Required(target = "doUpdate")
    public String previousStatusCode;

    //    @Required(target = "doUpdate, doDelete")
    public String versionNo;
}