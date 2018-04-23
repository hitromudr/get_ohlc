var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "500",
        "ok": "472",
        "ko": "28"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "2"
    },
    "maxResponseTime": {
        "total": "20",
        "ok": "20",
        "ko": "20"
    },
    "meanResponseTime": {
        "total": "10",
        "ok": "10",
        "ko": "10"
    },
    "standardDeviation": {
        "total": "6",
        "ok": "6",
        "ko": "6"
    },
    "percentiles1": {
        "total": "10",
        "ok": "10",
        "ko": "10"
    },
    "percentiles2": {
        "total": "15",
        "ok": "15",
        "ko": "15"
    },
    "percentiles3": {
        "total": "19",
        "ok": "19",
        "ko": "19"
    },
    "percentiles4": {
        "total": "19",
        "ok": "19",
        "ko": "20"
    },
    "group1": {
        "name": "t < 5 ms",
        "count": 118,
        "percentage": 24
    },
    "group2": {
        "name": "5 ms < t < 10 ms",
        "count": 144,
        "percentage": 29
    },
    "group3": {
        "name": "t > 10 ms",
        "count": 210,
        "percentage": 42
    },
    "group4": {
        "name": "failed",
        "count": 28,
        "percentage": 6
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "100",
        "ok": "94.4",
        "ko": "5.6"
    }
},
contents: {
"req_get-ohlc-value--98435": {
        type: "REQUEST",
        name: "get_ohlc(value)",
path: "get_ohlc(value)",
pathFormatted: "req_get-ohlc-value--98435",
stats: {
    "name": "get_ohlc(value)",
    "numberOfRequests": {
        "total": "500",
        "ok": "472",
        "ko": "28"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "2"
    },
    "maxResponseTime": {
        "total": "20",
        "ok": "20",
        "ko": "20"
    },
    "meanResponseTime": {
        "total": "10",
        "ok": "10",
        "ko": "10"
    },
    "standardDeviation": {
        "total": "6",
        "ok": "6",
        "ko": "6"
    },
    "percentiles1": {
        "total": "10",
        "ok": "10",
        "ko": "10"
    },
    "percentiles2": {
        "total": "15",
        "ok": "15",
        "ko": "15"
    },
    "percentiles3": {
        "total": "19",
        "ok": "19",
        "ko": "19"
    },
    "percentiles4": {
        "total": "19",
        "ok": "19",
        "ko": "20"
    },
    "group1": {
        "name": "t < 5 ms",
        "count": 118,
        "percentage": 24
    },
    "group2": {
        "name": "5 ms < t < 10 ms",
        "count": 144,
        "percentage": 29
    },
    "group3": {
        "name": "t > 10 ms",
        "count": 210,
        "percentage": 42
    },
    "group4": {
        "name": "failed",
        "count": 28,
        "percentage": 6
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "100",
        "ok": "94.4",
        "ko": "5.6"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
