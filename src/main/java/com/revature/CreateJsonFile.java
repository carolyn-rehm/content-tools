package com.revature;

import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

public class CreateJsonFile {

    public String getUUID() {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        return uuidStr;
    }

    public void createJson(String p_sUnitPath)
    {

        FileWriter writer = null;
        try {

            writer = new FileWriter(p_sUnitPath+"navigation.json");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        JsonGenerator generator
                = Json.createGenerator(writer);
        generator.writeStartObject()
                .write("id", getUUID())
                .write("title", "Next-Gen Foundation The-Modern-Microsoft-Workplace")
                .write("description", " The-Modern-Microsoft-Workplace")
                .writeStartObject("prerequisites")
                .write("url", "README")
                .write("title", "Prerequisites and Learning Objectives")
                .write("tooltip", "Prerequisites and Learning Objectives")
                .writeEnd()
                .writeStartObject("studyGuide")
                .write("url", "study-guide")
                .write("title", "study-guide")
                .write("tooltip", "study-guide")
                .writeEnd()
                .writeStartArray("modules")
                .writeStartObject()
                .write("id", getUUID())
                .write("title", "windows-os-literacy")
                .write("url", "modules/windows-os-literacy")
                .write("description"," windows-os-literacy")
                .write("tooltip"," windows-os-literacy")
                .writeStartObject("prerequisites")
                .write("url", "README")
                .write("title", "Prerequisites and Learning Objectives")
                .write("tooltip", "Prerequisites and Learning Objectives")
                .writeEnd()
                .writeStartArray("topics")
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/001-windows-os-literacy/001-windows-basics/Cumulative.md")
                .write("title"," Windows Basics")
                .write("tooltip"," windows-basics")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/001-windows-os-literacy/002-windows-navigation-and-file-system/Cumulative.md")
                .write("title"," Windows Navigation And File System")
                .write("tooltip"," windows-navigation-and-file-system")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/001-windows-os-literacy/003-working-with-web-browsers/Cumulative.md")
                .write("title"," Working With Web Browsers")
                .write("tooltip"," working-with-web-browsers")
                .writeEnd()
                .writeEnd()
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("title", "teams")
                .write("url", "modules/teams")
                .write("description"," teams")
                .write("tooltip"," teams")
                .writeStartObject("prerequisites")
                .write("url", "README")
                .write("title", "Prerequisites and Learning Objectives")
                .write("tooltip", "Prerequisites and Learning Objectives")
                .writeEnd()
                .writeStartArray("topics")
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/002-teams/001-teams-intro/Cumulative.md")
                .write("title"," Teams Intro")
                .write("tooltip"," teams-intro")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/002-teams/002-teams-channels-dms-and-group-chats/Cumulative.md")
                .write("title"," Teams Channels Dms And Group Chats")
                .write("tooltip"," teams-channels-dms-and-group-chats")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/002-teams/003-teams-calls-and-meetings/Cumulative.md")
                .write("title"," Teams Calls And Meetings")
                .write("tooltip"," teams-calls-and-meetings")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/002-teams/004-camera-etiquette/Cumulative.md")
                .write("title"," Camera Etiquette")
                .write("tooltip"," camera-etiquette")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/002-teams/005-teams-tags-and-notifications/Cumulative.md")
                .write("title"," Teams Tags And Notifications")
                .write("tooltip"," teams-tags-and-notifications")
                .writeEnd()
                .writeEnd()
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("title", "outlook")
                .write("url", "modules/outlook")
                .write("description"," outlook")
                .write("tooltip"," outlook")
                .writeStartObject("prerequisites")
                .write("url", "README")
                .write("title", "Prerequisites and Learning Objectives")
                .write("tooltip", "Prerequisites and Learning Objectives")
                .writeEnd()
                .writeStartArray("topics")
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/003-outlook/001-filter-and-search/Cumulative.md")
                .write("title"," Filter And Search")
                .write("tooltip"," filter-and-search")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/003-outlook/002-focused-inbox/Cumulative.md")
                .write("title"," Focused Inbox")
                .write("tooltip"," focused-inbox")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/003-outlook/003-sweep-tool/Cumulative.md")
                .write("title"," Sweep Tool")
                .write("tooltip"," sweep-tool")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/003-outlook/004-automatic-replies/Cumulative.md")
                .write("title"," Automatic Replies")
                .write("tooltip"," automatic-replies")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/003-outlook/005-people-tab/Cumulative.md")
                .write("title"," People Tab")
                .write("tooltip"," people-tab")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/003-outlook/006-todo-list-integration/Cumulative.md")
                .write("title"," Todo List Integration")
                .write("tooltip"," todo-list-integration")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/003-outlook/007-reporting-phishing-emails/Cumulative.md")
                .write("title"," Reporting Phishing Emails")
                .write("tooltip"," reporting-phishing-emails")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/003-outlook/008-email-folders/Cumulative.md")
                .write("title"," Email Folders")
                .write("tooltip"," email-folders")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/003-outlook/009-sticky-notes/Cumulative.md")
                .write("title"," Sticky Notes")
                .write("tooltip"," sticky-notes")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/003-outlook/010-calendars/Cumulative.md")
                .write("title"," Calendars")
                .write("tooltip"," calendars")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/003-outlook/011-outlook-rules/Cumulative.md")
                .write("title"," Outlook Rules")
                .write("tooltip"," outlook-rules")
                .writeEnd()
                .writeEnd()
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("title", "active-directory-overview")
                .write("url", "modules/active-directory-overview")
                .write("description"," active-directory-overview")
                .write("tooltip"," active-directory-overview")
                .writeStartObject("prerequisites")
                .write("url", "README")
                .write("title", "Prerequisites and Learning Objectives")
                .write("tooltip", "Prerequisites and Learning Objectives")
                .writeEnd()
                .writeStartArray("topics")
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/004-active-directory-overview/001-ad-intro/Cumulative.md")
                .write("title"," Ad Intro")
                .write("tooltip"," ad-intro")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/004-active-directory-overview/002-organizational-units-and-group-policy-objects/Cumulative.md")
                .write("title"," Organizational Units And Group Policy Objects")
                .write("tooltip"," organizational-units-and-group-policy-objects")
                .writeEnd()
                .writeStartObject()
                .write("id", getUUID())
                .write("url", "modules/004-active-directory-overview/003-types-of-ad-controllers/Cumulative.md")
                .write("title"," Types Of Ad Controllers")
                .write("tooltip"," types-of-ad-controllers")
                .writeEnd()
                .writeEnd()
                .writeEnd()
                .writeEnd()
                .writeEnd();
        generator.close();
    }

    public static void main(String ar[])
    {
        CreateJsonFile l_objtest=new CreateJsonFile();
        l_objtest.createJson("C:\\Users\\CarolynRehm\\Documents\\Content\\The-Modern-Microsoft-Workplace\\");
    }

}
