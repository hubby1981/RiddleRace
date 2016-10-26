package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import biitworx.games.race.riddle.riddlerace.MainMenu;
import biitworx.games.race.riddle.riddlerace.R;
import biitworx.games.race.riddle.riddlerace.TE;
import biitworx.games.race.riddle.riddlerace.data.helper.DbReference;
import biitworx.games.race.riddle.riddlerace.data.helper.JSONHelper;
import biitworx.games.race.riddle.riddlerace.data.helper.ObjectHelper;


/**
 * Created by marce_000 on 12.10.2016.
 */
public class Levels {

    static String base ="{\"sets\":[{\"name\":\"Basic\",\"collected\":\"0\",\"uid\":\"21c176a6-c6bb-48e0-859b-9e483a0a1521\",\"stars\":\"40\",\"editable\":\"false\",\"levels\":[{\"min\":\"10\",\"max\":\"30\",\"score\":\"0\",\"name\":\"Level 1 - Start\",\"uid\":\"7a537e69-4ae5-408b-8f40-826b96d5c2c9\",\"med\":\"20\",\"next\":\"Level 1 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"0\",\"pointx\":\"0\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"270\",\"direction\":\"1\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"8a2b24b1-b914-4487-ae07-855c84e5210a\",\"mover\":\"2\"},{\"posy\":\"0\",\"pointx\":\"4\",\"inverse\":\"5\",\"next\":\"5\",\"position\":\"90\",\"direction\":\"2\",\"freaky\":\"25\",\"posx\":\"20\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"c8d382ed-1c3a-4afe-a341-e2fd474dfb84\",\"mover\":\"2\"}]},{\"min\":\"10\",\"max\":\"30\",\"score\":\"0\",\"name\":\"Level 2 - Rings\",\"uid\":\"6037da25-62b8-42b6-ae7b-bc64121f4844\",\"med\":\"20\",\"next\":\"Level 2 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"10\",\"pointx\":\"1\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"1\",\"freaky\":\"0\",\"posx\":\"10\",\"pointy\":\"1\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"e972be80-3ad0-4917-9671-ba6d9297bab5\",\"mover\":\"2\"},{\"posy\":\"10\",\"pointx\":\"3\",\"inverse\":\"5\",\"next\":\"5\",\"position\":\"80\",\"direction\":\"0\",\"freaky\":\"50\",\"posx\":\"10\",\"pointy\":\"3\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"32999b8b-7728-4f09-9825-810c79757413\",\"mover\":\"2\"}]},{\"min\":\"20\",\"max\":\"40\",\"score\":\"0\",\"name\":\"Level 3 - Fallout\",\"uid\":\"01bb109e-f157-4000-aed7-f57a83b3913b\",\"med\":\"30\",\"next\":\"Level 3 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"0\",\"pointx\":\"1\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"320\",\"direction\":\"1\",\"freaky\":\"0\",\"posx\":\"10\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"5ff57d2a-fa2a-4f0f-bb62-6e9ac8a38cf9\",\"mover\":\"4\"},{\"posy\":\"0\",\"pointx\":\"3\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"40\",\"direction\":\"2\",\"freaky\":\"0\",\"posx\":\"10\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"7764539d-9ec1-4056-b268-1304925d46ed\",\"mover\":\"5\"}]},{\"min\":\"30\",\"max\":\"70\",\"score\":\"0\",\"name\":\"Level 4 - Hazard\",\"uid\":\"90e19608-f8db-46f5-9876-5d1db3078dd4\",\"med\":\"50\",\"next\":\"Level 4 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"10\",\"pointx\":\"0\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"70\",\"direction\":\"3\",\"freaky\":\"16\",\"posx\":\"20\",\"pointy\":\"3\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"061fdf97-fa1b-4e96-ad22-d2300ba5f7ce\",\"mover\":\"3\"},{\"posy\":\"10\",\"pointx\":\"4\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"260\",\"direction\":\"0\",\"freaky\":\"5\",\"posx\":\"20\",\"pointy\":\"3\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"7\",\"uid\":\"3401e2ba-7c56-44d5-b990-f254ea60caef\",\"mover\":\"1\"},{\"posy\":\"10\",\"pointx\":\"2\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"2\",\"freaky\":\"20\",\"posx\":\"0\",\"pointy\":\"1\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"3\",\"uid\":\"ed5b2145-0116-4703-bd40-7265d56bc03e\",\"mover\":\"2\"}]},{\"min\":\"30\",\"max\":\"50\",\"score\":\"0\",\"name\":\"Level 5 - Funny\",\"uid\":\"711555cc-541d-4e1f-b553-6c9c1fac5224\",\"med\":\"40\",\"next\":\"Level 5 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"10\",\"pointx\":\"1\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"1\",\"freaky\":\"0\",\"posx\":\"10\",\"pointy\":\"1\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"5b188ac8-5b77-4683-842e-6ad5ae26e203\",\"mover\":\"3\"},{\"posy\":\"10\",\"pointx\":\"1\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"3\",\"freaky\":\"0\",\"posx\":\"10\",\"pointy\":\"3\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"5\",\"uid\":\"1010b6e4-7dfe-400d-8a8c-2332ed4b76a6\",\"mover\":\"2\"},{\"posy\":\"0\",\"pointx\":\"3\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"50\",\"direction\":\"2\",\"freaky\":\"30\",\"posx\":\"10\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"45862af7-c401-4670-9eb0-58829c888614\",\"mover\":\"4\"}]},{\"min\":\"40\",\"max\":\"80\",\"score\":\"0\",\"name\":\"Level 6 - Snowman\",\"uid\":\"ff9dc185-2f7b-4fba-8758-4c51d6933680\",\"med\":\"60\",\"next\":\"Level 6 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"10\",\"pointx\":\"2\",\"inverse\":\"7\",\"next\":\"7\",\"position\":\"0\",\"direction\":\"2\",\"freaky\":\"0\",\"posx\":\"0\",\"pointy\":\"1\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"7\",\"uid\":\"3ce9fb19-a5ca-40ac-b174-139e76d34177\",\"mover\":\"1\"},{\"posy\":\"0\",\"pointx\":\"2\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"70\",\"direction\":\"0\",\"freaky\":\"0\",\"posx\":\"0\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"10a08f0a-e523-47e6-8cf5-bcdf3a4dac0c\",\"mover\":\"2\"},{\"posy\":\"10\",\"pointx\":\"2\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"3\",\"freaky\":\"0\",\"posx\":\"0\",\"pointy\":\"3\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"3\",\"uid\":\"9e79667a-626c-4fef-9912-e25d9538a36a\",\"mover\":\"2\"}]},{\"min\":\"30\",\"max\":\"50\",\"score\":\"0\",\"name\":\"Level 7 - Pyramid\",\"uid\":\"d57c30e5-e73b-447e-ae3f-a29717d40ab4\",\"med\":\"40\",\"next\":\"Level 7 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"10\",\"pointx\":\"2\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"2\",\"freaky\":\"0\",\"posx\":\"0\",\"pointy\":\"1\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"49fba907-0b92-4621-8f09-d6c7d956f691\",\"mover\":\"3\"},{\"posy\":\"10\",\"pointx\":\"1\",\"inverse\":\"8\",\"next\":\"8\",\"position\":\"0\",\"direction\":\"3\",\"freaky\":\"20\",\"posx\":\"10\",\"pointy\":\"3\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"61fbc278-6da4-47c1-953b-34af615ac7d3\",\"mover\":\"2\"},{\"posy\":\"10\",\"pointx\":\"3\",\"inverse\":\"5\",\"next\":\"5\",\"position\":\"60\",\"direction\":\"0\",\"freaky\":\"20\",\"posx\":\"10\",\"pointy\":\"3\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"19be35d3-3350-41e3-9565-acab425810c4\",\"mover\":\"1\"}]},{\"min\":\"40\",\"max\":\"80\",\"score\":\"0\",\"name\":\"Level 8 - Arrow\",\"uid\":\"ecc85c57-0862-4ccb-88aa-362bd214fb48\",\"med\":\"60\",\"next\":\"Level 8 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"20\",\"pointx\":\"1\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"3\",\"freaky\":\"0\",\"posx\":\"10\",\"pointy\":\"4\",\"faktor\":\"6\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"3673c32f-7cbb-45f1-8f4a-9a72d542953a\",\"mover\":\"2\"},{\"posy\":\"10\",\"pointx\":\"2\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"60\",\"direction\":\"3\",\"freaky\":\"0\",\"posx\":\"0\",\"pointy\":\"3\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"f67060b3-f183-41ff-89c0-fe60fde303ee\",\"mover\":\"2\"},{\"posy\":\"0\",\"pointx\":\"3\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"20\",\"direction\":\"2\",\"freaky\":\"0\",\"posx\":\"10\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"32a63b58-65c9-4125-9d64-bcfa35af9fcc\",\"mover\":\"4\"}]},{\"min\":\"50\",\"max\":\"90\",\"score\":\"0\",\"name\":\"Level 9 - Titel & Love\",\"uid\":\"d18c5907-9b28-45bb-8764-115537383d0a\",\"med\":\"70\",\"next\":\"Level 9 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"10\",\"pointx\":\"0\",\"inverse\":\"5\",\"next\":\"5\",\"position\":\"20\",\"direction\":\"3\",\"freaky\":\"30\",\"posx\":\"20\",\"pointy\":\"3\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"dd916f35-4b8a-46bc-a552-df89fe5ac1eb\",\"mover\":\"2\"},{\"posy\":\"10\",\"pointx\":\"0\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"260\",\"direction\":\"1\",\"freaky\":\"5\",\"posx\":\"20\",\"pointy\":\"1\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"1f048ac3-3729-4ed6-ba01-5213776606a5\",\"mover\":\"3\"},{\"posy\":\"10\",\"pointx\":\"4\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"40\",\"direction\":\"2\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"1\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"cbf42170-851c-4983-bc80-4ab4f770c212\",\"mover\":\"3\"},{\"posy\":\"10\",\"pointx\":\"4\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"90\",\"direction\":\"0\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"3\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"3\",\"uid\":\"7bc7d8e7-1397-4b51-82dc-05a5d2f064f9\",\"mover\":\"2\"}]},{\"min\":\"70\",\"max\":\"110\",\"score\":\"0\",\"name\":\"Level 10 - Crazy\",\"uid\":\"89c0b3e1-561e-42d0-9429-72beb12f4a0d\",\"med\":\"90\",\"next\":\"Level 10 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"20\",\"pointx\":\"0\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"1\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"0\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"6b01f3bd-891a-4e4b-82c5-a92bd6091c0d\",\"mover\":\"2\"},{\"posy\":\"0\",\"pointx\":\"2\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"0\",\"freaky\":\"0\",\"posx\":\"0\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"d834c2bc-8fea-44f2-9c77-4b392e8f7b61\",\"mover\":\"2\"},{\"posy\":\"20\",\"pointx\":\"2\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"3\",\"freaky\":\"0\",\"posx\":\"0\",\"pointy\":\"4\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"4f3913ad-a843-44e8-88bd-2cf099d5c8b8\",\"mover\":\"2\"},{\"posy\":\"20\",\"pointx\":\"4\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"2\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"0\",\"faktor\":\"5\",\"length\":\"1\",\"color\":\"3\",\"uid\":\"480f8a1e-b8ef-45d7-8b82-d993523be797\",\"mover\":\"3\"}]},{\"min\":\"40\",\"max\":\"100\",\"score\":\"0\",\"name\":\"Level 11 - House\",\"uid\":\"82d969c7-d2b1-45a5-932b-16a6e915c92a\",\"med\":\"70\",\"next\":\"Level 11 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"20\",\"pointx\":\"0\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"30\",\"direction\":\"3\",\"freaky\":\"10\",\"posx\":\"20\",\"pointy\":\"4\",\"faktor\":\"4\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"bb7364ab-eb48-4296-ac97-af643e021acc\",\"mover\":\"3\"},{\"posy\":\"0\",\"pointx\":\"0\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"1\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"01c4473e-a42b-4ca9-a990-10a4596cd006\",\"mover\":\"4\"},{\"posy\":\"0\",\"pointx\":\"4\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"80\",\"direction\":\"2\",\"freaky\":\"15\",\"posx\":\"20\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"44e279df-8332-4d62-a2a2-ef350bf7521b\",\"mover\":\"3\"},{\"posy\":\"20\",\"pointx\":\"4\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"0\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"4\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"3\",\"uid\":\"bb196a3e-0d94-4093-8d1e-e6ad6cf02190\",\"mover\":\"2\"}]},{\"min\":\"60\",\"max\":\"90\",\"score\":\"0\",\"name\":\"Level 12 - River\",\"uid\":\"ecdf1330-2b70-488e-bcd6-5b42f45727fc\",\"med\":\"80\",\"next\":\"Level 12 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"20\",\"pointx\":\"0\",\"inverse\":\"8\",\"next\":\"8\",\"position\":\"30\",\"direction\":\"1\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"0\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"ab087312-d286-4bf9-b05f-3c7b5c0ba701\",\"mover\":\"3\"},{\"posy\":\"20\",\"pointx\":\"4\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"2\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"0\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"b071b692-696a-4735-96c5-df5205a4ac6c\",\"mover\":\"2\"},{\"posy\":\"20\",\"pointx\":\"0\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"270\",\"direction\":\"3\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"4\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"9b502949-71be-4305-948e-e2f57a9c999e\",\"mover\":\"2\"},{\"posy\":\"0\",\"pointx\":\"2\",\"inverse\":\"6\",\"next\":\"6\",\"position\":\"340\",\"direction\":\"0\",\"freaky\":\"0\",\"posx\":\"0\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"3\",\"uid\":\"74cc382f-f5eb-435d-84ad-7ab0d9a4d5f1\",\"mover\":\"2\"}]},{\"min\":\"60\",\"max\":\"80\",\"score\":\"0\",\"name\":\"Level 13 - Clown \",\"uid\":\"154d1bf0-2fd8-41db-abb7-8e181f4cbc92\",\"med\":\"70\",\"next\":\"Level 13 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"0\",\"pointx\":\"0\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"260\",\"direction\":\"1\",\"freaky\":\"8\",\"posx\":\"20\",\"pointy\":\"2\",\"faktor\":\"6\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"02059bef-a5bd-4483-bba2-c1a63c869b38\",\"mover\":\"2\"},{\"posy\":\"10\",\"pointx\":\"1\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"320\",\"direction\":\"1\",\"freaky\":\"5\",\"posx\":\"10\",\"pointy\":\"1\",\"faktor\":\"6\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"a6136aac-02ba-4c35-8c70-27260ff161b7\",\"mover\":\"2\"},{\"posy\":\"10\",\"pointx\":\"1\",\"inverse\":\"7\",\"next\":\"7\",\"position\":\"20\",\"direction\":\"3\",\"freaky\":\"23\",\"posx\":\"10\",\"pointy\":\"3\",\"faktor\":\"6\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"c092e3f4-e5f0-46a6-b2c1-36184af1874b\",\"mover\":\"3\"},{\"posy\":\"0\",\"pointx\":\"4\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"50\",\"direction\":\"2\",\"freaky\":\"16\",\"posx\":\"20\",\"pointy\":\"2\",\"faktor\":\"6\",\"length\":\"1\",\"color\":\"3\",\"uid\":\"f159213a-db26-4780-be49-3a413780ae2c\",\"mover\":\"3\"}]},{\"min\":\"70\",\"max\":\"130\",\"score\":\"0\",\"name\":\"Level 14 - Zyklus \",\"uid\":\"fa07dcaa-c173-4e60-acf7-f56467ef9a1a\",\"med\":\"100\",\"next\":\"Level 14 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"20\",\"pointx\":\"2\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"3\",\"freaky\":\"0\",\"posx\":\"0\",\"pointy\":\"4\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"ae2aa66d-d116-4fd1-a667-4c3c2e41ed01\",\"mover\":\"4\"},{\"posy\":\"20\",\"pointx\":\"0\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"1\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"0\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"d3cf1cd2-ebfd-4b8f-ad08-40430b582a38\",\"mover\":\"2\"},{\"posy\":\"0\",\"pointx\":\"1\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"60\",\"direction\":\"1\",\"freaky\":\"27\",\"posx\":\"10\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"7f3a3d0d-1474-4c61-9b7a-6c0cf3916f5a\",\"mover\":\"2\"},{\"posy\":\"0\",\"pointx\":\"3\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"2\",\"freaky\":\"0\",\"posx\":\"10\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"3\",\"uid\":\"1f2e8a91-7562-4dcc-9f9b-6b53860b5993\",\"mover\":\"2\"},{\"posy\":\"20\",\"pointx\":\"4\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"290\",\"direction\":\"2\",\"freaky\":\"10\",\"posx\":\"20\",\"pointy\":\"0\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"4\",\"uid\":\"232cb927-7c95-4a83-a2ea-1dadc99cf20c\",\"mover\":\"3\"}]},{\"min\":\"60\",\"max\":\"80\",\"score\":\"0\",\"name\":\"Level 15 - They get it\",\"uid\":\"0b97c6ce-335f-47f4-abd7-7c4e55024db4\",\"med\":\"70\",\"next\":\"Level 15 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"10\",\"pointx\":\"0\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"1\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"1\",\"faktor\":\"6\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"fc9ce981-151a-4eb3-bf3e-46213e4e5b4f\",\"mover\":\"2\"},{\"posy\":\"0\",\"pointx\":\"1\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"290\",\"direction\":\"1\",\"freaky\":\"0\",\"posx\":\"10\",\"pointy\":\"2\",\"faktor\":\"6\",\"length\":\"1\",\"color\":\"5\",\"uid\":\"37602c29-a3e9-402c-94eb-a400f1e60fd6\",\"mover\":\"2\"},{\"posy\":\"0\",\"pointx\":\"3\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"320\",\"direction\":\"2\",\"freaky\":\"0\",\"posx\":\"10\",\"pointy\":\"2\",\"faktor\":\"4\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"c0a6a317-7ebf-4abb-83a8-532fc1981eaf\",\"mover\":\"4\"},{\"posy\":\"10\",\"pointx\":\"4\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"60\",\"direction\":\"0\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"3\",\"faktor\":\"4\",\"length\":\"1\",\"color\":\"3\",\"uid\":\"f094211f-06a6-4ad1-b9bf-80ba3da5131e\",\"mover\":\"3\"}]},{\"min\":\"70\",\"max\":\"110\",\"score\":\"0\",\"name\":\"Level 16 - Goodies \",\"uid\":\"0d75306c-a2d8-4e6b-b3b6-e434c11cebd0\",\"med\":\"90\",\"next\":\"Level 16 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"10\",\"pointx\":\"3\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"0\",\"freaky\":\"0\",\"posx\":\"10\",\"pointy\":\"3\",\"faktor\":\"3\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"32dacefb-a8ca-42a4-9042-40ac77d46f4a\",\"mover\":\"2\"},{\"posy\":\"10\",\"pointx\":\"1\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"280\",\"direction\":\"3\",\"freaky\":\"17\",\"posx\":\"10\",\"pointy\":\"3\",\"faktor\":\"5\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"92381238-3324-4c65-a928-ff47ea73e41c\",\"mover\":\"4\"},{\"posy\":\"10\",\"pointx\":\"1\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"300\",\"direction\":\"1\",\"freaky\":\"0\",\"posx\":\"10\",\"pointy\":\"1\",\"faktor\":\"4\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"d6bf79d1-24f5-49c2-a6ce-4ce512a1bacd\",\"mover\":\"2\"},{\"posy\":\"20\",\"pointx\":\"2\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"0\",\"direction\":\"2\",\"freaky\":\"20\",\"posx\":\"0\",\"pointy\":\"0\",\"faktor\":\"10\",\"length\":\"1\",\"color\":\"3\",\"uid\":\"d3f3afe0-7eb4-44b7-825e-a42d473135ca\",\"mover\":\"3\"}]},{\"min\":\"70\",\"max\":\"110\",\"score\":\"0\",\"name\":\"Level 17 - Postman \",\"uid\":\"de82db3f-5488-4d2b-820c-1663244c02b7\",\"med\":\"90\",\"next\":\"Level 17 - unbekannt\",\"editable\":\"false\",\"circles\":[{\"posy\":\"0\",\"pointx\":\"0\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"270\",\"direction\":\"1\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"2\",\"faktor\":\"5\",\"length\":\"1\",\"color\":\"0\",\"uid\":\"8d91698f-d6ea-4f7c-91c8-96ab7cf9571d\",\"mover\":\"2\"},{\"posy\":\"0\",\"pointx\":\"2\",\"inverse\":\"5\",\"next\":\"5\",\"position\":\"0\",\"direction\":\"0\",\"freaky\":\"50\",\"posx\":\"0\",\"pointy\":\"2\",\"faktor\":\"2\",\"length\":\"1\",\"color\":\"1\",\"uid\":\"fa8bf8fd-5840-4b03-9dc2-4a2b2581b0b2\",\"mover\":\"2\"},{\"posy\":\"0\",\"pointx\":\"4\",\"inverse\":\"10\",\"next\":\"10\",\"position\":\"90\",\"direction\":\"2\",\"freaky\":\"0\",\"posx\":\"20\",\"pointy\":\"2\",\"faktor\":\"5\",\"length\":\"1\",\"color\":\"2\",\"uid\":\"6d784f1d-5f0c-4cc3-ae49-081688eb49a4\",\"mover\":\"4\"}]}]}]}";


    public static Sets all=new Sets();

    static {
        all.sets = MainMenu.DATA.getData(LevelSet.class, MainMenu.DATA.get(), true);
        if (all.sets == null || all.sets.size() == 0) {
            setupSets();
        }

    }

    public static Level getLevel(UUID id) {
        Level r = null;
        for (LevelSet s : all.sets) {
            for (Level l : s.getLevels()) {
                if (l.getUID().equals(id)) {
                    r = l;
                    break;
                }
            }
        }
        return r;
    }

    public static LevelSet getLevelSet(UUID id) {
        Level r = null;
        for (LevelSet s : all.sets) {
            for (Level l : s.getLevels()) {
                if (l.getUID().equals(id)) {
                    return s;

                }
            }
        }
        return null;
    }

    public static LevelSet getSet(String name) {
        for (LevelSet s : all.sets)
            if (s.getName().equals(name))
                return s;
        return null;
    }

    public static void removeLevel(Level level) {

    }

    public static void updateLevel(Level level, boolean insert) {

        MainMenu.DATA.insert(level, insert, MainMenu.DATA.get());

        LevelSet bundle = null;
        for (LevelSet b : all.sets) {
            if (b.getLevels().contains(level)) {
                bundle = b;
            }
        }
        if (bundle != null) {
            int stars = 0;
            for (Level l : bundle.getLevels()) {
                stars += l.getScore() >= l.getMax() ? 3 : l.getScore() >= l.getMed() ? 2 : l.getScore() >= l.getMin() ? 1 : 0;
            }
            bundle.setCollected(stars);
            MainMenu.DATA.insert(bundle, false, MainMenu.DATA.get());

        }

    }

    public static int[] getRedArray() {
        return new int[]{76, 224, 33, 103, 255, 0, 205, 233, 25, 253};
    }

    public static int[] getGreenArray() {
        return new int[]{175, 67, 150, 58, 87, 150, 220, 30, 25, 216};
    }

    public static int[] getBlueArray() {
        return new int[]{80, 54, 243, 183, 34, 136, 57, 99, 25, 53};
    }

    public static void updateSet(LevelSet set) {
        MainMenu.DATA.insert(set, false, MainMenu.DATA.get());
    }

    private static void setupSets() {
        setupBasicSet();
    }

    private static void setupBasicSet() {

        try {
            JSONObject o = new JSONObject(base);

            if(o!=null){
                Sets s = JSONHelper.mapToObject(Sets.class,o);
                if(s!=null){
                    all=s;
                    for(LevelSet ss : all.sets) {
                        MainMenu.DATA.insert(ss, true, MainMenu.DATA.get());
                    }
                }
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
