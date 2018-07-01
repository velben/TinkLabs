package com.ouweibin.interview.core.exception

/**
 * 处理errors/failures/exceptions的基类
 */
sealed class Failure{
    class NetworkConnection: Failure()
    class ServerError: Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure: Failure()
}