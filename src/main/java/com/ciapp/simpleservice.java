package com.ciapp;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class simpleservice {

	public static void main(String[] args) {
		Options options = new Options();
		options.addOption("n", true, "[name] your name");
		Option timeOption = new Option("t", false, "current time");
		options.addOption("h", false, "find hostname");
		options.addOption(timeOption);
		CommandLineParser parser = new BasicParser();
		CommandLine cmd;
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException pe) {
			usage(options);
			return;
		}
		if (cmd.getOptions().length == 0){
			usage(options);
			System.exit(1);
			
		}
		if (cmd.hasOption("t")) {

			System.err.println("Date/Time: " + new java.util.Date());
		}
		if (cmd.hasOption("h")) {
			try {
				System.out.println("Hostname is: "+InetAddress.getLocalHost().getHostName());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if (cmd.hasOption("n")) {
			System.err.println("Nice to meet you: " + cmd.getOptionValue('n'));
		}
		
	}

	private static void usage(Options options) {

		// Use the inbuilt formatter class
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("CLIDemo", options);
	}

}
