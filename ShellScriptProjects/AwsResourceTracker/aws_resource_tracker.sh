#!/bin/bash
#############################
# Author: Himanshu Kumar
# Date: 10 October 2024
# Version: v1.0
#
# This bash script will report the AWS resource usage
# ###################################
set -x
#
#We will track below resources: 
# 	Aws S3
#	AWS EC2
# 	AWS lambda
# 	AWS IAM Users
#
#List ASW S3 bucket
echo "*****************Print list of S3 buckets********************"
aws ec2 describe-instances | jq '.Reservations[].Instances[].InstanceId'

#List EC2 Instances
echo "****************************Print list of ec2 instances*****************************"
aws ec2 describe-instances

#list aws lambda
echo "******************************Print lambda****************************"
aws lambda list-functions

#list IAM users
echo "**********************************Print IAM User**********************************"
aws iam list-users > resourceTracker
