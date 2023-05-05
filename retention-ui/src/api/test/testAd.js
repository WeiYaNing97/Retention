import request from '@/utils/request'

// 查询广告测试列表
export function listTestAd(query) {
  return request({
    url: '/test/testAd/list',
    method: 'get',
    params: query
  })
}

// 查询广告测试详细
export function getTestAd(id) {
  return request({
    url: '/test/testAd/' + id,
    method: 'get'
  })
}

// 新增广告测试
export function addTestAd(data) {
  return request({
    url: '/test/testAd',
    method: 'post',
    data: data
  })
}

// 修改广告测试
export function updateTestAd(data) {
  return request({
    url: '/test/testAd',
    method: 'put',
    data: data
  })
}

// 删除广告测试
export function delTestAd(id) {
  return request({
    url: '/test/testAd/' + id,
    method: 'delete'
  })
}
