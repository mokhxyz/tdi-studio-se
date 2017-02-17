package org.talend.msg.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hsmf.MAPIMessage;
import org.apache.poi.hsmf.datatypes.AttachmentChunks;
import org.apache.poi.hsmf.datatypes.Chunk;
import org.apache.poi.hsmf.datatypes.MAPIProperty;
import org.apache.poi.hsmf.datatypes.StringChunk;
import org.apache.poi.hsmf.datatypes.Types;
import org.apache.poi.hsmf.exceptions.ChunkNotFoundException;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class MsgMailUtil {

	private String outAttachmentPath;
	private MAPIMessage msg;
	private Logger log;
	private String position;

	public MsgMailUtil() {
	}

	public MsgMailUtil(String fileName, String outAttachmentPath)
			throws IOException {
		msg = new MAPIMessage(fileName);
		this.outAttachmentPath = outAttachmentPath;
	}

	public void activeLog(Logger log, String position) {
		this.log = log;
		this.position = position;
	}

	public void getAttachments() throws IOException {
		AttachmentChunks[] attachments = msg.getAttachmentFiles();
		if (attachments.length > 0) {
			File d = new File(outAttachmentPath);
			if (!d.exists()) {
				processLog(Level.DEBUG,
						"Specified attachments' export directory doesn't exist");
				d.mkdirs();// Create output path if it not exist.
				processLog(Level.DEBUG, "Directory " + d.getAbsolutePath()
						+ " was created successfully");
			}
			for (AttachmentChunks attachment : attachments) {
				processAttachment(attachment, d);
			}
		}
	}

	public void processAttachment(AttachmentChunks attachment, File dir)
			throws IOException {
		String fileName = attachment.attachFileName.toString();
		if (attachment.attachLongFileName != null) {
			fileName = attachment.attachLongFileName.toString();
		}

		File attachedFile = new File(dir, fileName);
		OutputStream fileOut = null;
		try {
			processLog(Level.INFO, "Exporting attachment file :" + fileName);
			processLog(Level.INFO,
					"File location:" + attachedFile.getAbsolutePath());

			fileOut = new FileOutputStream(attachedFile);
			fileOut.write(attachment.attachData.getValue());

			processLog(Level.INFO, "Export successfully");
		} finally {
			if (fileOut != null) {
				fileOut.close();
			}
		}
	}

	public Object processMessage(String mailPart) throws ChunkNotFoundException {
		if ("From".equalsIgnoreCase(mailPart)) {
			return msg.getDisplayFrom();
		} else if ("To".equalsIgnoreCase(mailPart)) {
			return msg.getDisplayTo();
		} else if ("CC".equalsIgnoreCase(mailPart)) {
			return msg.getDisplayCC();
		} else if ("BCC".equalsIgnoreCase(mailPart)) {
			return msg.getDisplayBCC();
		} else if ("Subject".equalsIgnoreCase(mailPart)) {
			return msg.getSubject();
		} else if ("Body".equalsIgnoreCase(mailPart)) {
			return msg.getTextBody();
		} else if ("ConversationTopic".equalsIgnoreCase(mailPart)) {
			return msg.getConversationTopic();
		} else if ("HtmlBody".equalsIgnoreCase(mailPart)) {
			return msg.getHtmlBody();
		} else if ("MessageDate".equalsIgnoreCase(mailPart)) {
			java.util.Calendar messageDate = msg.getMessageDate();
			return messageDate.getTime();
		} else if ("RecipientAddress".equalsIgnoreCase(mailPart)) {
			return msg.getRecipientEmailAddress();
		} else if ("RecipientAddressList".equalsIgnoreCase(mailPart)) {
			return msg.getRecipientEmailAddressList();
		} else if ("RecipientNames".equalsIgnoreCase(mailPart)) {
			return msg.getRecipientNames();
		} else if ("RecipientNamesList".equalsIgnoreCase(mailPart)) {
			return msg.getRecipientNamesList();
		} else if ("RtfBody".equalsIgnoreCase(mailPart)) {
			return msg.getRtfBody();
		} else {
			return null;
		}
	}

	public void processLog(Level level, String message) {
		message = position + " - " + message;
		if (this.log != null) {
			switch (level.toInt()) {
			case Level.TRACE_INT:
				log.trace(message);
				break;
			case Level.ERROR_INT:
				log.error(message);
				break;
			case Level.FATAL_INT:
				log.fatal(message);
				break;
			case Level.INFO_INT:
				log.info(message);
				break;
			case Level.WARN_INT:
				log.warn(message);
				break;
			default:
				break;
			}
		}
	}

	public String getOutAttachmentPath() {
		return outAttachmentPath;
	}

	public void setOutAttachmentPath(String outAttachmentPath) {
		this.outAttachmentPath = outAttachmentPath;
	}

	public MAPIMessage getMsg() {
		return msg;
	}

	public void setMsg(MAPIMessage msg) {
		this.msg = msg;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}