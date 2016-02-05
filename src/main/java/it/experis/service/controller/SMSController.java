package it.experis.service.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import it.experis.service.bean.SMS;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParamBean;
import org.apache.http.util.EntityUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SMSController {


    
    @RequestMapping(method=RequestMethod.GET, value="/sms")
    public ModelAndView renderSMSView(ModelMap model) {
    	SMS sms = new SMS();
    	String [] recipients = new String[]{"393478205663","393478205663"};
    	String [] methodList = new String[]{"Classico","Classico Con Notifica","Base"};
    	String username = "fsimone123";
    	String password = "simone";
    	sms.setUsername(username);
    	sms.setPassword(password);
    	sms.setRecipients(recipients);
    	sms.setMethodList(methodList);
    	model.put("SMSView", sms);
        return new ModelAndView("SMSView", "sms", sms);
        
    }
    
    
    @RequestMapping(method=RequestMethod.POST, value="/sms/send")
    public ModelAndView sendSMS(@ModelAttribute("SpringWeb")SMS sms, ModelMap model) {
    	String esito = "NESSUN RISULTATO";
        String charset = sms.getCharset();
        String smsType = sms.getSmsType();
        String username = sms.getUsername();
        String password = sms.getPassword();
        String senderNumber = sms.getSenderNumber();
        String senderString = sms.getSenderString();
        String text = sms.getText();
        String method = sms.getMethod();
        String[] recipients = sms.getRecipients();
        
        
    	if (!charset.equals("UTF-8") && !charset.equals("ISO-8859-1")) {
    		throw new IllegalArgumentException("Charset non supportato.");
    	}
    	
    	if (method.equals("Classico") ) {
    		smsType = new String("send_sms_classic");    		
    	} else if (method.equals("Classico Con Notifica") ) {
    		smsType = new String("send_sms_classic_report");
    	} else if (method.equals("Base") ) {
    		smsType = new String("send_sms_basic");
    	} else {
            // PER AVERE 100 SMS GRATIS
            smsType = new String("get_free_sms");
            //smsType = new String("test_send_sms_classic");
            //smsType = new String("test_send_sms_classic_report");
            //smsType = new String("test_send_sms_basic");
    	}
    	
    	String endpoint = "http://gateway.skebby.it/api/send/smseasy/advanced/http.php";
    	//String endpoint = "http://gateway.skebby.it/api/gift/http.php";
    	
        // Set HTTP Connection
    	HttpParams params = new BasicHttpParams();
    	HttpConnectionParams.setConnectionTimeout(params, 10*1000);
    	DefaultHttpClient httpclient = new DefaultHttpClient(params);
    	HttpProtocolParamBean paramsBean = new HttpProtocolParamBean(params);
    	paramsBean.setVersion(HttpVersion.HTTP_1_1);
    	paramsBean.setContentCharset(charset);
        paramsBean.setHttpElementCharset(charset);

        // Set HTTP Proxy
		HttpHost proxy = new HttpHost("10.128.1.15",8080);
		httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,proxy);

        // Set SMS parameter
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("method", smsType));
        formparams.add(new BasicNameValuePair("username", username));
        formparams.add(new BasicNameValuePair("password", password));
        if(!senderNumber.isEmpty())
            formparams.add(new BasicNameValuePair("sender_number", senderNumber));
        if(!senderString.isEmpty())
            formparams.add(new BasicNameValuePair("sender_string", senderString));         
        for (String recipient : recipients) {
        	if (!recipient.isEmpty() && !recipient.equals("39")) {
        		formparams.add(new BasicNameValuePair("recipients[]", recipient));        		
        	}
        }
        formparams.add(new BasicNameValuePair("text", text));
        formparams.add(new BasicNameValuePair("charset", charset));

        // Set URL for request
        UrlEncodedFormEntity entity = null;
		try {
			entity = new UrlEncodedFormEntity(formparams, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
        HttpPost post = new HttpPost(endpoint);
        post.setEntity(entity);
        
        // Invio SMS
        HttpResponse response = null;
		try {
			response = httpclient.execute(post);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        // Leggo Esito SMS		
        HttpEntity resultEntity = response.getEntity();
        if(null != resultEntity){
            try {
            	//esito = resultEntity.toString();
            	esito = EntityUtils.toString(resultEntity);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return new ModelAndView("SMSResult", "smsResponse", esito);
    }
        
	    
    
}
