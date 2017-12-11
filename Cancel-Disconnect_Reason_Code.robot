*** Settings ***
Suite Setup       Run keyword    Set Screenshot Directory    ScreenShots
Suite Teardown  Run keywords    Close All Browsers
Resource          SPPortal_Lib.robot
Resource          ../POM.txt
Resource          ../Common.robot
Variables         SPPortal_Vars.py    # Variables
Variables         SPCreateAndView_Vars.py

*** Variables ***

*** Test Cases ***
RLTOQA-18324:Verify the Cancel Reason Code Drop Down Menu Values
    [Documentation]    Regression
    [Tags]    Regression
    Login To RialtoSp
#    Navigate To Link    Order List
#    Wait And Click Element    name=viewall
#    Wait And Click Element    name=viewall
#    Wait And Click Element    name=viewprocessing
#    Wait And Click Element    name=viewcreated
#    Navigate to Link    Find
#    Clicking And Verifying    //table[@id='colorCheatSheet']//following::tbody[1]/tr[1]/td[4]/a    //li[@class='h3']/a[1]    Order
    Navigate To Link    Find Orders
    Wait Until Page Is Loaded
    Input Text    //input[@name='companyName']    AutoCust2
    Navigate to Link    Lookup Order(s)
    Wait And Click Element    //table[@class='sortable']//tbody//tr[1]//td[1]
    Wait Until Page Is Loaded
    Wait And Click Element    //table[@class='basic-table']//*[text()='Cancel Order']
    sleep    2
    select window    title=Cancel Order
    Wait Until Element Is Enabled    ${sp_cancelreasonsel}
    Wait And Click Element    id=cancelReasonSel
    Sleep    ${min_sleep}
    ReasonForCancel
    Sleep    ${min_sleep}
    select window    title=Service Provider Portal
#    Logout
    [Teardown]    Close Browser

RLTOQA-18325:Verify the Disconnect Reason Code Drop Down Menu Values
    [Documentation]    Regression
    [Tags]    Regression
    Login To RialtoSp
    Navigate To Link    Customer Service Tool
    Enter Input    companyName    AutomationCustomerFinal
    Wait And Click Element    //*[text()='Lookup Customer Info']
	Clicking And Verifying    //*[text()='(32761) AutoSipTrunking']    ${sp_cancelservice}    Disconnect Service Items
    Clicking And Verifying    id=cancelServiceItemsHref    //*[text()='Disconnect Order']    Disconnect Order
    Wait Until Element Is Enabled    id=orderDisconReasonCd
    Page Should Contain Element    ${sp_updatebillingaccount}
    Wait And Click Element    ${sp_orderdisconnectreason}
	Page Should Contain Element    //option[contains(text(),'Non-Pay')]
	ReasonForCancel
	select window    title=Service Provider Portal
    ##Logout
    [Teardown]    Close Browser

RLTOQA-18326:Cancel a NEW Order in Pending Terms and Conditions
    [Documentation]    Regression
    [Tags]    Address
    Login To RialtoSp
    Navigate To Link    Create Quote
    Wait Until Element Is Enabled    id=customerName
    Enter Input    customerName    AutoCust2
    Wait And Click Element    //a[text()='AutoCust2']
    Clicking And Verifying    ${sp_createsite}    //*[text()='Site(s)']    Site(s)
    Wait And Click Element    ${sp_postaladdressuse}
    Wait And Click Element    //*[@id='useContactInfo']/input
    Enter Input    companyLocationName    ${sitename}
    Wait And Click Element    ${PS_site_type}
    Wait And Click Element    //*[@value='HOSTED_PBX']
    Wait And Click Element    ${PS_internet_SP}
    Wait And Click Element    //*[@value='VERIZON']
    Wait And Click Element    ${PS_access_type}
    Wait And Click Element    //*[@value='DSL_5MB']
    Wait And Click Element    ${sp_sitesave}
    Run Keyword And Ignore Error    Wait And Click Element    ${sp_formsave}
    Navigate To link    Initiate Request
    Examinet    AutoCust2    ${sitename}
    Enter Input    contactLastName    XYZ
    Wait And Click Element    //*[text()='Submit']
    Wait Until Element Is Enabled    ${sp_homebutton}
    Wait And Click Element    ${sp_homebutton}
    ListOrder    AutoCust2    ${sitename}
    Wait And Click Element    ${sp_ordernumber}
    Wait And Click Element    ${sp_ordernumber}/option[@value='5']
    Wait And Click Element    ${sp_continue}
    Page Should Contain Element    //*[@id='cartUpdate']
    Wait And Click Element    ${sp_continue}
    Page Should Contain Element    //td[text()='New Order']
    Wait And Click Element    //*[text()='Save']
    Page Should Contain Element    //*[text()='ExamiNet Assessment']
    Wait And Click Element    //*[@id='examinetAssessComplete']
    Wait And Click Element    ${sp_contactaffirmation}
    Wait And Click Element    ${sp_checkout}
    Wait And Click Element    //*[text()='Continue']
    Wait until element is visible    ${sp_cname}
    Input Text    ${sp_cname}    Hello
    Input Text    ${sp_numberprefix}    567890
    Wait And Click Element    ${sp_continue}
    Wait And Click Element    ${sp_dlid}
    Wait And Click Element    ${sp_continue}
    ${NewOrderQuoteId}    Get Text    //*[@id='contentOrder']//*[contains(@href,'quoteId')]
    Wait And Click Element    ${sp_submitorder}
    Page Should Contain Element    //*[text()='Home']
    Wait And Click Element    ${sp_cancelorder}
    Sleep    4
    select window    title=Cancel Order
    Wait Until Element Is visible    ${sp_cancelreasonsel}
    Clicking And Verifying    ${sp_yes}    //*[@id='reasonCdMissing']    Reason must be selected
    Wait And Click Element    ${sp_cancelreasonsel}
    ReasonForCancel
    select window    title=Service Provider Portal
#    Logout
    [Teardown]    Close Browser

RLTOQA-18327:Cancel a ADD Order in Pending Terms and Conditions
    [Documentation]    Regression
    [Tags]    Regression
    Login To RialtoSp
    ListOrder    AutoCust2    Liverpool
    Page Should Contain Element    //*[@id='cartUpdate']
    Wait And Click Element    ${sp_continue}
    Page Should Contain Element    //*[@id='cartUpdate']
    sleep    10
    Wait And Click Element    ${sp_continue}
    Page Should contain Element    //*[@id='productTypeIdEXT_INST_SERVICES3_MAC']
    Wait And Click Element    //*[@id='productTypeIdEXT_INST_SERVICES3_MAC']
    Wait And Click Element    ${sp_continue}
    Page Should Contain Element    //*[text()='Add Order']
    Wait And Click Element    //*[text()='Save']
    Page Should Contain Element    ${sp_contactaffirmation}
    Wait And Click Element    ${sp_contactaffirmation}
    Wait And Click Element    ${sp_checkout}
    Wait And Click Element    ${sp_continue}
    Page Should contain element    //*[text()='Service Activation Date']
    Wait And Click Element    ${sp_continue}
    ${NewOrderQuoteId}    Get Text    //*[@id='contentOrder']//*[contains(@href,'quoteId')]
    Wait And Click Element    ${sp_submitorder}
    Page Should Contain Element    //*[text()='Home']
    Wait And Click Element    ${sp_cancelorder}
    Sleep    4
    select window    title=Cancel Order
    Wait Until Element Is Enabled    ${sp_cancelreasonsel}
    Clicking And Verifying    ${sp_yes}    //*[@id='reasonCdMissing']    Reason must be selected
    Wait And Click Element    ${sp_cancelreasonsel}
    ReasonForCancel
    select window    title=Service Provider Portal
#    Logout
    [Teardown]    Close Browser

RLTOQA-18328:Cancel a Field Services Order via Order List
    [Documentation]    Regression
    [Tags]    Regression
    Login To RialtoSp
    Navigate To Link    Create Field Services Quote
    Input Text    id=customerName    AutoCust2
    Wait And Click Element    //div[text()='AutoCust2']
    Wait Until Element Is Visible    id=locationName
    Wait Until Element Is Enabled    id=locationName    100
    Input Text    id=locationName    Liverpool
    Wait And Click Element    //div[text()='Liverpool']
    Wait And Click Element    ${sp_continue}
    Page Should contain Element    //*[@id='cartUpdate']
    Wait And Click Element    //*[@id='productTypeIdEXT_INST_SERVICES1_SITE_SURVEY']
    Wait And Click Element    //*[@id='productTypeIdSP_EXT_INST_SERVICES1_SP_SITE_SURVEY']
    Wait And Click Element    ${sp_continue}
    Page Should contain Element    //*[text()='Customer Information']
    Wait And Click Element    //*[text()='Save']
    Page Should contain Element    //*[text()='Customer Contact Affirmation']
    Wait And Click Element    ${sp_contactaffirmation}
    Wait And Click Element    ${sp_checkout}
    Wait And Click Element    ${sp_continue}
    Wait And Click Element    ${sp_submitorder}
    Page Should Contain Element    //*[text()='Home']
    Wait And Click Element    ${sp_cancelorder}
    Sleep    4
    select window    title=Cancel Order
    Wait Until Element Is Enabled    ${sp_cancelreasonsel}
    Clicking And Verifying    ${sp_yes}    //*[@id='reasonCdMissing']    Reason must be selected
    Wait And Click Element    ${sp_cancelreasonsel}
    ReasonForCancel
    select window    title=Service Provider Portal
#    Logout
    [Teardown]    Close Browser

RLTOQA-18332:Cancel a NEW Order
    [Documentation]    Regression
    [Tags]    Regression
    Login To RialtoSp
    CancelAnOrder    typeneworder
    select window    title=Service Provider Portal
#    Logout
    [Teardown]    Close Browser

RLTOQA-18333:Cancel an ADD Order
    [Documentation]    Regression
    [Tags]    Regression
    Login To RialtoSp
    CancelAnOrder    typeaddorder
    select window    title=Service Provider Portal
#    Logout
    [Teardown]    Close Browser

*** keywords ***
ListOrder
    [Arguments]    ${CustName}    ${SiteName}
    Navigate To Link    Create Quote
    Input Text    id=customerName    ${CustName}
    Wait And Click Element    //div[text()='${CustName}']
    Wait Until Element Is Visible    id=locationName
    Wait Until Element Is Enabled    id=locationName    100
    Input Text    id=locationName    ${SiteName}
    Wait And Click Element    //div[text()='${SiteName}']
    Wait And Click Element    ${sp_continue}
    Page Should Contain Element    //*[@id='cartUpdate']
    Wait Until Element Is Enabled    ${sp_basicstation}
    Input Text    ${sp_basicstation}    1
    Input Text    ${sp_commonareastation}    1
    Input Text    ${sp_standarduserstation}    1
    Input Text    ${sp_broadtouchmobile}    5
    Input Text    ${sp_broadtouchpc}    10
    #Wait And Click Element    ${sp_Custom}
    #Input Text    ${sp_customergeneric}    1
    Wait And Click Element    ${sp_continue}
    Page Should Contain Element    //*[@id='cartUpdate']
    Input Text    ${sp_quantityat-pc-vvx}    10
    Input Text    ${sp_quantityat-pc-vvxp}    5
    sleep    10
    Wait And Click Element    ${sp_continue}

CancelOrder
    Wait And Click Element    ${sp_cancelorder}
    Wait Until Element Is Enabled    ${sp_cancelorder}
    Select Window    title=Cancel Order
    Wait And Click Element    ${sp_cancelreasonsel}
    Wait And Click Element    ${sp_competition-features}
    Wait And Click Element    ${sp_yes}

ReasonForCancel
    Page Should Contain Element    //option[contains(text(),'Competition - Features')]
    Page Should Contain Element    //option[contains(text(),'Competition - Pricing')]
    Page Should Contain Element    //option[contains(text(),'Fix Error - Customer')]
    Page Should Contain Element    //option[contains(text(),'Fix Error - Sales')]
    Page Should Contain Element    //option[contains(text(),'Internet Inadequate')]
    Page Should Contain Element    //option[contains(text(),'No Longer Needed')]
    Page Should Contain Element    //option[contains(text(),'Not as Expected - Features')]
    Page Should Contain Element    //option[contains(text(),'Not as Expected - Pricing')]
    Page Should Contain Element    //option[contains(text(),'Not as Expected - Quality')]
    Page Should Contain Element    //option[contains(text(),'Not as Expected - Usability')]

CancelAnOrder
    [Arguments]    ${TypeOfOrder}
    Navigate to Link    Order List
    Checkbox Should Not Be Selected    //*[@name='typeall']
    Wait And Click Element    //*[@name='typeall']
    Checkbox Should Be Selected    //*[@name='typeall']
    Wait And Click Element    //*[@name='typeall']
    Wait And Click Element    //*[@name='${TypeOfOrder}']
    Wait And Click Element    //*[@name='viewall']
    Wait And Click Element    //input[@name='viewcompleted']
    Wait And Click Element    //input[@name='viewcancelled']
    Wait And Click Element    //*[text()='Find']
    Wait And Click Element    //table[@id='colorCheatSheet']/tbody/tr[1]/td[4]/a
    Wait And Click Element    ${sp_cancelorder}
    Sleep    10
    Select Window    title=Cancel Order
    Wait Until Element Is Enabled    ${sp_cancelreasonsel}
    Wait And Click Element    ${sp_cancelreasonsel}
    ReasonForCancel
