package com.vn.osp.notarialservices.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vn.osp.notarialservices.transaction.dto.SynchonizeContractKey;
import com.vn.osp.notarialservices.transaction.dto.TransactionProperty;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tranv on 12/7/2016.
 */
public class STPAPIUtil {
    private static final Logger LOGGER = Logger.getLogger(STPAPIUtil.class);
    public static void callAPI(String actionURL, String data) {
        try {
            URL url = new URL(actionURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            String input = data.toString();
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes("UTF-8"));
            os.flush();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));
            String output;
            while ((output = br.readLine()) != null) {
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Boolean callAPIResult(String actionURL, String data) {
        try {
            URL url = new URL(actionURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            String input = data.toString();
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes("UTF-8"));
            os.flush();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));
            String output;
            Boolean result;
            output = br.readLine();
            conn.disconnect();
            if (output.equals("true")) return true;
            else return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Long callAddPreventAPI(String actionURL, String data) {
        try {
            URL url = new URL(actionURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            String input = data.toString();
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes("UTF-8"));
            os.flush();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));
            String output;
            Long prevent_id = Long.valueOf(0);
            while ((output = br.readLine()) != null) {
                prevent_id = Long.parseLong(output);
            }
            conn.disconnect();
            return prevent_id;
        } catch (Exception e) {
            e.printStackTrace();
            return Long.valueOf(0);
        }
    }
    public static Long callUpdatePreventAPI(String actionURL, String data) {
        try {
            URL url = new URL(actionURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            String input = data.toString();
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes("UTF-8"));
            os.flush();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));
            String output;
            Long prevent_id = Long.valueOf(0);
            while ((output = br.readLine()) != null) {
                prevent_id = Long.parseLong(output);
            }
            conn.disconnect();
            return prevent_id;
        } catch (Exception e) {
            e.printStackTrace();
            return Long.valueOf(0);
        }
    }

    public static Long addUserAPI(String actionURL, String data) {
        try {
            URL url = new URL(actionURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            String input = data.toString();
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes("UTF-8"));
            os.flush();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));
            String output;
            Long prevent_id = Long.valueOf(0);
            while ((output = br.readLine()) != null) {
                prevent_id = Long.parseLong(output);
            }
            conn.disconnect();
            return prevent_id;
        } catch (Exception e) {
            e.printStackTrace();
            return Long.valueOf(0);
        }
    }

    public static Boolean updateUserAPI(String actionURL, String data) {
        try {
            URL url = new URL(actionURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            String input = data.toString();
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes("UTF-8"));
            os.flush();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));
            String output;
            Boolean result = false;
            while ((output = br.readLine()) != null) {
                result = Boolean.parseBoolean(output);
            }
            conn.disconnect();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int countTotalList(String actionURL, String data) {
        try {
            URL url = new URL(actionURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            String input = data.toString();
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes("UTF-8"));
            os.flush();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));
            String output;
            int result = 0;
            while ((output = br.readLine()) != null) {
                result = Integer.parseInt(output);
            }
            conn.disconnect();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }



    public static List<TransactionProperty> getTransactionPropertyList(String actionURL, String data) {
        try {
            URL url = new URL(actionURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            String input = data.toString();
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes("UTF-8"));
            os.flush();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));
            String output;
            ArrayList<TransactionProperty> list = new ArrayList<TransactionProperty>();
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            while ((output = br.readLine()) != null) {
                JSONArray jsonArray = new JSONArray(output);
                if (jsonArray != null) {
                    int len = jsonArray.length();
                    for (int i = 0; i < len; i++) {
                        list.add(mapper.readValue(jsonArray.get(i).toString(), TransactionProperty.class));

                    }
                }
            }
            conn.disconnect();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<SynchonizeContractKey> synchronizeContract(String actionURL, String data) {
        try {
            URL url = new URL(actionURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            //conn.setRequestProperty("Accept-Charset", "UTF-8");

            String input = data.toString();

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes("UTF-8"));
            os.flush();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));

            String output;
            List<SynchonizeContractKey> list = new ArrayList<SynchonizeContractKey>();
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            while ((output = br.readLine()) != null) {
                JSONArray jsonArray = new JSONArray(output);
                if (jsonArray != null) {
                    int len = jsonArray.length();
                    for (int i=0;i<len;i++){
                        list.add(mapper.readValue(jsonArray.get(i).toString(), SynchonizeContractKey.class));
                    }
                }
            }
            conn.disconnect();
            return list;
        } catch (ConnectException e) {
            LOGGER.error("Mat ket noi den server stp");
            return null;
        }catch (IOException e) {
            LOGGER.error("Bad Request");
            return null;
        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }
    
}
